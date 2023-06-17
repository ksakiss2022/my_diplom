package ru.skypro.homework.service;



import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.RegisterReqModel;
import ru.skypro.homework.model.User;

import java.util.Optional;

@Service
public interface UserService {

    public UserDto update(UserDto user, String email);

    public Optional<UserDto> getUser(String name);

    public UserDto updateUser(UserDto user, Integer id);
}

