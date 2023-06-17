package ru.skypro.homework.dto;

import lombok.Data;
import ru.skypro.homework.model.Comment;

import java.util.Objects;

/**
 * Класс CommentDto содержит поля для хранения информации о комментариях, такие как идентификатор, автор комментария,
 * изображение автора, время создания, текст комментария.
 */
//@Data// позволяет генерировать методы getter и setter, а также методы hashCode, equals и toString для класса CommentDto.
@Data
public class CommentDto {
    private Integer author;
    private String authorImage;
    private String authorFirstName;
    private Long createdAt;
    private Integer pk;
    private String text;
}