package ru.skypro.homework.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;

@Service
@Slf4j
public class ImageService {
    private final ImageRepository imageRepository;
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;

    public ImageService(ImageRepository imageRepository, AdsRepository adsRepository, UserRepository userRepository) {
        this.imageRepository = imageRepository;
        this.adsRepository = adsRepository;
        this.userRepository = userRepository;
    }

    public String saveImage(MultipartFile image) {
        return null;
    }

}
