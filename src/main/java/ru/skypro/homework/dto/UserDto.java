package ru.skypro.homework.dto;

import lombok.Data;
import ru.skypro.homework.model.Image;

import java.util.Objects;


/**
 * Класс для передачи данных между слоями приложения или между приложением и базой данных.
 * Он представляет собой простой класс с набором свойств (полей),
 * которые соответствуют полям в сущности базы данных. UserDto.
 * DTO обычно используется для того, чтобы уменьшить количество
 * пересылаемых данных между клиентом и сервером, а также для защиты
 * конфиденциальности данных, и для того чтобы скрыть сложности взаимодействия с
 * базой данных. Он может также помочь в улучшении производительности приложения,
 * поскольку уменьшает количество запросов.
 */

//@Data//// добавляет методы getter и setter для каждого поля класса, а также методы toString, equals и hashCode.
@Data
public class UserDto {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Image avatar;
}