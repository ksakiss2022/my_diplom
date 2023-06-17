package ru.skypro.homework.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.mappers.AdsMapper;
import ru.skypro.homework.model.Ads;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.ImageService;

import javax.persistence.EntityNotFoundException;
//import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class AdsServiceImpl implements AdsService {
    private final AdsRepository adsRepository;
    private final ImageService imageService;
    private final UserRepository userRepository;


    public AdsServiceImpl(AdsRepository adsRepository, ImageService imageService, UserRepository userRepository) {
        this.adsRepository = adsRepository;
        this.imageService = imageService;
        this.userRepository = userRepository;
    }


    @Override
    public List<AdsDto> getAllAds() {
        List<Ads> ads = adsRepository.findAll();
        return ads.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    private AdsDto convertToDto(Ads ads) {
        AdsDto adsDto = new AdsDto();
        adsDto.setTitle(ads.getTitle());
        adsDto.setPrice(ads.getPrice());
        adsDto.setImage(ads.getImage());
        return adsDto;
    }

    @Override
    public AdsDto addAd(AdsDto adsDto, MultipartFile image) throws IOException {

        Ads ads = new Ads();
        ads.setTitle(adsDto.getTitle());
        ads.setImage(adsDto.getImage());
        ads.setPrice(adsDto.getPrice());

        String imagePath = imageService.saveImage(image);
        ads.setImagePath(imagePath);

        // Сохраняем объявление
        Ads savedAds = adsRepository.save(ads);

        // Конвертируем Ads в AdsDto
        AdsDto savedAdsDto = new AdsDto();
        savedAdsDto.setTitle(savedAds.getTitle());
        savedAdsDto.setImage(savedAds.getImage());
        savedAdsDto.setPrice(savedAds.getPrice());

        return savedAdsDto;
    }

    @Override
    public AdsDto getAds(Integer id) {
        Optional<Ads> optionalAds = adsRepository.findById(Math.toIntExact(id));
        if (optionalAds.isEmpty()) {
            throw new EntityNotFoundException("Ads not found with id " + id);
        }
        Ads ads = optionalAds.get();
        AdsDto adsDto = new AdsDto();
        adsDto.setTitle(ads.getTitle());
        adsDto.setPrice(ads.getPrice());
        adsDto.setImage(ads.getImage());
        return adsDto;
    }

    @Override
    public void removeAd(Integer id) {
        Optional<Ads> optionalAds = adsRepository.findById(id);
        if (optionalAds.isEmpty()) {
            throw new EntityNotFoundException("Ads not found with id " + id);
        }
        Ads ads = optionalAds.get();
        adsRepository.delete(ads);
    }

    @Override
    public String updateAds(AdsDto adsDto, Integer id) {
        Ads adsFromDb = adsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ads not found with id: " + id));
        adsFromDb.setTitle(adsDto.getTitle());
        adsFromDb.setPrice(adsDto.getPrice());
        adsFromDb.setImage(adsDto.getImage());
        adsRepository.save(adsFromDb);
        return adsDto.getImage().toString();
    }

    @Override
    public List<AdsDto> getAdsByUserId(Integer userId) {
        return null;
    }


    @Override
    public List<AdsDto> getAdsByUserId(Long userId) {
        return null;
    }

    @Override
    public Collection<AdsDto> getMe(String email) {
        log.info("Get ads: " + email);
        Integer authorId = userRepository.findByEmail(email).get().getId();
        Collection<Ads> ads = adsRepository.findAllByAuthorId(Long.valueOf(authorId));
        return ads.isEmpty() ? null : AdsMapper.INSTANCE.adsCollectionToAdsDto(ads);
    }

    @Override
    public List<AdsDto> getAdsByCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            UserPrincipal userPrincipal = (UserPrincipal) ((org.springframework.security.core.Authentication) authentication).getPrincipal();
            return getAdsByUserId(Integer.valueOf(userPrincipal.getName()));
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public byte[] updateImage(Integer id, MultipartFile image) throws IOException {
        log.info("Update image: " + id);
        imageService.saveImage(image);
        log.info("Photo have been saved");
        return image.getBytes();
    }

}