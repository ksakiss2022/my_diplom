package ru.skypro.homework.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.homework.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * В интерфейсе UserRepository определены методы для поиска пользователей по различным критериям, таким как Id,
 * имя, фамилия, электронная почта, изображение и телефонный номер.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer id);

    Optional<User> findUserByEmailIs(String email);

    Optional<User> findByEmail(String email);



}
