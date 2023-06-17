package ru.skypro.homework.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserService;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMap modelMapper;
    private final ImageService imageService;

    public UserServiceImpl(UserRepository userRepository,
                           UserService userService,
                           ModelMap modelMapper,
                           ImageService imageService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.imageService = imageService;
    }

    @Override
    public Optional<UserDto> getUser(String name) {
        log.info("Get user: " + name);
        return userRepository.findByEmail(name).map(UserMapper.INSTANCE::userToUserDto);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer id) {
        log.info("Update user: " + user);
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        return UserMapper.INSTANCE.userToUserDto(
                userRepository.save(UserMapper.INSTANCE.userDtoToUser(user))
        );
    }
       @Override
        public UserDto update(UserDto userDto, String email) {
            User updatedUser = UserMapper.INSTANCE.userDtoToUser(userDto);
            log.info("Update user: " + updatedUser);
            return UserMapper.INSTANCE.userToUserDto(userRepository.save(updatedUser));
        }


}
