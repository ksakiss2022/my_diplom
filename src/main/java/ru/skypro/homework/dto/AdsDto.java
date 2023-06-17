package ru.skypro.homework.dto;

import lombok.Data;

import java.util.Objects;

/**
 * Класс AdsDto содержит поля для хранения информации об объявлениях Ads, такие как идентификатор, идентификатор
 * создателя, заголовок, цена и изображение.
 */

//@Data//позволяет автоматически создать методы getter и setter, а также методы toString, equals и hashCode для класса
// AdsDto, а также некоторые другие методы, такие как методы для сравнения двух объектов по значениям и нахождения хэш-кода.
@Data
public class AdsDto {
   // private Integer author;
    private String image;
    private Long pk;
    private Integer price;
    private String title;
    private Long author;
}