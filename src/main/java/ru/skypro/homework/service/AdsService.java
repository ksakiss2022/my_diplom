package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDto;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
@Service
public interface AdsService {
    Iterable<AdsDto> getAllAds();

    void removeAd(Integer id);

    AdsDto addAd(AdsDto adsDto, MultipartFile image) throws IOException;

    AdsDto getAds(Integer id);

    String updateAds(AdsDto adsDto, Integer id);

    List<AdsDto> getAdsByUserId(Integer userId);

    Collection<AdsDto> getMe(String email);

    List<AdsDto> getAdsByCurrentUser();

    byte[] updateImage(Integer id, MultipartFile image) throws IOException;

   // List<AdsDto> getAdsByUserId(Integer userId);
   List<AdsDto> getAdsByUserId(Long userId);
}
