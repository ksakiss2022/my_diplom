package ru.skypro.homework.model;

import lombok.Data;

import java.util.Objects;

/**
 * Класс LoginReqModel содержит данные для авторизации пользователя. Этот класс используется для передачи информации
 * с запросом на сервер.
 * Класс имеет два поля – password и username, которые служат для хранения пароля и имени пользователя.
 */
//@Data
public class LoginReqModel {
    //аннотацию @LoginReqProperty, описывает свойства поля (пароль или логин) и их описание. Подобные аннотации
    // могут использоваться для добавления информации о полях при создании документации или интерфейса пользователя.
    @LoginReqProperty(description = "пароль")
    private String password;

    @LoginReqProperty(description = "логин")
    private String username;

    public LoginReqModel(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginReqModel that = (LoginReqModel) o;
        return password.equals(that.password) && username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username);
    }

    @Override
    public String toString() {
        return "LoginReqModel{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
