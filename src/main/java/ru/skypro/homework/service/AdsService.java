package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.model.Ads;
import ru.skypro.homework.repository.AdsRepository;

@Service
public class AdsService {
    private final AdsRepository adsRepository;

    public AdsService(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    public Ads save(AdsDto adsDto) {
        Ads ads = new Ads();
        ads.setTitle(adsDto.getTitle());
        ads.setPrice(adsDto.getPrice());
        ads.setImage(adsDto.getImage());

        Ads savedAds = adsRepository.save(ads);

        return savedAds;
    }


    private <S extends AdsDto> S createAdsDto(Ads ad) {
        S adsDto = (S) new AdsDto();
        adsDto.setId(ad.getId());
        adsDto.setTitle(ad.getTitle());
        adsDto.setPrice(ad.getPrice());
        adsDto.setImage(ad.getImage());

        return adsDto;
    }
}
