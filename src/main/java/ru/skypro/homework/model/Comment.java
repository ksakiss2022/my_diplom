package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * В классе `Comment`(Коментарий) определены конструкторы для создания объектов класса,а также методы геттеров и сеттеров для доступа
 * к полям. Методы `equals()`, `hashCode()` и `toString()` вызываются при сравнении, хешировании и преобразовании
 * объекта в строку.
 */

@Entity
//@Data//позволяет сгенерировать геттеры, сеттеры, методы equals и hashCode.
@Table(name = "comment")// указывает на имя таблицы в базе данных, связанной с этой сущностью.
public class Comment {

    @Id//указывает, что поле id является идентификатором сущности.
    private Integer id;
    private int author;
    //  private String authorImage; // должно быть ы юзер
    // private String authorFirstName; // должно быть ы юзер
    private long createdAt;
    private int pk;

    @NotBlank
    @Size(max = 200)
    private String text;//У поля text есть дополнительные ограничения, заданные аннотациями @NotBlank и @Size.
    // Это означает, что поле не может быть пустым и не может содержать более 200 символов.

    public Comment() {
    }

    public Comment(int author, long createdAt, int pk, String text) {
        this.author = author;
        //   this.authorImage = authorImage;
        //this.authorFirstName = authorFirstName;
        this.createdAt = createdAt;
        this.pk = pk;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return author == comment.author && createdAt == comment.createdAt && pk == comment.pk && id.equals(comment.id) && text.equals(comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, createdAt, pk, text);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author=" + author +
                ", createdAt=" + createdAt +
                ", pk=" + pk +
                ", text='" + text + '\'' +
                '}';
    }

}
