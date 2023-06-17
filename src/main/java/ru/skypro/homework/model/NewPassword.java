package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Класс NewPassword является сущностью, которая связана с таблицей "newPassword" в базе данных.
 */
@Entity //указывает на то, что этот класс является сущностью.
//@Data//позволяет сгенерировать геттеры, сеттеры, методы equals и hashCode.
@Table(name = "newPassword")//указывает на имя таблицы в базе данных, связанной с этой сущностью.
public class NewPassword {
    @Id//указывает, что поле id является идентификатором сущности.
    private Integer id;

    //Поле currentPassword помечено аннотацией @NotBlank, это означает, что оно не может быть пустым. Аннотация @Size
    // задает минимальное и максимальное количество символов, которые могут быть в поле newPassword.
    @NotBlank//аннотация означает, что оно не может быть пустым.
    private String currentPassword;

    @NotBlank//аннотация означает, что оно не может быть пустым.
    @Size(min = 6, max = 20)
//задает минимальное и максимальное количество символов, которые могут быть в поле newPassword.
    private String newPassword;

    public NewPassword(Integer id, String currentPassword, String newPassword) {
        this.id = id;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public NewPassword() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewPassword that = (NewPassword) o;
        return id.equals(that.id) && currentPassword.equals(that.currentPassword) && newPassword.equals(that.newPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currentPassword, newPassword);
    }

    @Override
    public String toString() {
        return "NewPassword{" +
                "id=" + id +
                ", currentPassword='" + currentPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
