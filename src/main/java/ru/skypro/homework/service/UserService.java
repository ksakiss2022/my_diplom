package ru.skypro.homework.service;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
////    private final UserRepository userRepository;// внедрение UserRepository
////
////    private final PasswordEncoder passwordEncoder;// внедрение PasswordEncoder, для шифрования пароля
////
////    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
////        this.userRepository = userRepository;
////        this.passwordEncoder = passwordEncoder;
////    }
////
////    public User findUserById(Integer id) {
////        return userRepository.findUserById(id);
////    }
////
////    public User findUserByEmail(String email) {
////        return userRepository.findUserByEmail(email);
////    }
////
////    public User save(User user) {
////        return userRepository.save(user);
////    }
////
////    public void delete(User user) {
////        userRepository.delete(user);
////    }
////
////    public List<User> findAll() {
////        return userRepository.findAll();
////    }
////
////    public List<User> findUsersByFirstName(String firstName) {
////        return (List<User>) userRepository.findUserByFirstNameContainsIgnoreCase(firstName);
////    }
////
////    public List<User> findByLastNameContainingIgnoreCase(String lastName){
////        return (List<User>) userRepository.findUserByLastNameContainingIgnoreCase(lastName);
////    }
////
////    public User findUserByImage(String image){
////        return userRepository.findUserByImage(image);
////    }
////
////    public User findUserByPhone(String phone){
////        return userRepository.findUserByPhone(phone);
////    }
//
////    public void setPassword(User user, String password){
////        user.setPassword(passwordEncoder.encode(password));
////    }
//
//
//    private final UserRepository userRepository;// внедрение UserRepository
//
//    private final PasswordEncoder passwordEncoder;// внедрение PasswordEncoder, для шифрования пароля
//
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
////        public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
////            this.userRepository = userRepository;
////            this.passwordEncoder = passwordEncoder;
////        }
//
//
//    public UserDto getUserById(Integer id) {
//        User user = userRepository.findUserById(id);
//        if (user != null) {
//            return convertToDto(user);
//        } else {
//            return null;
//        }
//    }
//
//
//    public UserDto getUserByFirstName(String firstName) {
//        User user = userRepository.findUserByFirstNameContainsIgnoreCase(firstName);
//        if (user != null) {
//            return convertToDto(user);
//        } else {
//            return null;
//        }
//    }
//
//    private UserDto convertToDto(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setEmail(user.getEmail());
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setPhone(user.getPhone());
//        userDto.setImage(user.getImage());
//        return userDto;
//    }
//
//
////        public User createUser(User user) {
////            user.setPassword(passwordEncoder.encode(user.getPassword()));
////            return userRepository.save(user);
////        }
//
//    //    @Override
//    //    public User getUserById(Integer id) {
//    //        return userRepository.findUserById(id);
//    //    }
//    //
//    //    @Override
//    //    public User getUserByFirstName(String firstName) {
//    //        return userRepository.findUserByFirstNameContainsIgnoreCase(firstName);
//    //    }
//
//    public User findUserById(Integer id) {
//        return userRepository.findUserById(id);
//    }
//
//    public User findUserByEmail(String email) {
//        return userRepository.findUserByEmail(email);
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//
//    public void delete(User user) {
//        userRepository.delete(user);
//    }
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public List<User> findUsersByFirstName(String firstName) {
//        return (List<User>) userRepository.findUserByFirstNameContainsIgnoreCase(firstName);
//    }
//
//    public List<User> findByLastNameContainingIgnoreCase(String lastName){
//        return (List<User>) userRepository.findUserByLastNameContainingIgnoreCase(lastName);
//    }
//
//    public User findUserByImage(String image){
//        return userRepository.findUserByImage(image);
//    }
//
//    public User findUserByPhone(String phone){
//        return userRepository.findUserByPhone(phone);
//    }
//
////    public void setPassword(User user, String password){
////        user.setPassword(passwordEncoder.encode(password));
////    }
}

