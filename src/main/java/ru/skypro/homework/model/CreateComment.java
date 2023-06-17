package ru.skypro.homework.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
/**
 Класс CreateComment содержит информацию о новом комментарии.
 */
public class CreateComment {

    @NotBlank// аннотация сообщает, что поле text не должно быть пустым.
    @Size(max = 200)//аннотация указывает на максимальное количество символов в строке.
    private String text;

     public CreateComment() {
    }

    public CreateComment(String text) {
        this.text = text;
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
        CreateComment that = (CreateComment) o;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "CreateComment{" +
                "text='" + text + '\'' +
                '}';
    }


}
