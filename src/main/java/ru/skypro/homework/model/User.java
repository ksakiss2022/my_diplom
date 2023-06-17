package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.skypro.homework.dto.Role;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Аннотация @Entity говорит JPA/Hibernate, что класс является сущностью базы данных. Она позволяет привязать класс к
 * таблице в базе данных. В данном случае класс User является сущностью, которая будет храниться в таблице "users".
 * Атрибуты класса описывают различные параметры пользователя, такие как его имя, фамилию, адрес электронной почты,
 * телефонную информацию и т.д.
 */
@Entity
//@Data//добавляет в класс методы генерации геттеров, сеттеров, метода hashCode(), метода equals() и метода toString()
// для всех полей класса автоматически.
@Table(name = "users")// указывает, что таблица, с которой ассоциирован класс User, имеет имя "users".
public class User {

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Collection<Ads> ads;

    @Id// указывает, что поле id является первичным ключом, уникальным для каждой записи таблицы.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//указывает, что значения id генерируются автоматически.
    @NotNull//указывает, что поле не может иметь значение null.
    @Min(1)// указывает, что значение поля должно быть больше указанной константы.
    private Integer id;
    @NotBlank//указывает, что строковое значение поля не может быть пустым.
    @Email//указывает, что значение поля должно быть корректным email-адресом.
    private String email;

    @NotBlank////указывает, что строковое значение поля не может быть пустым.
    @Size(max = 50)//указывает ограничения на длину строки.
    private String firstName;

    @NotBlank////указывает, что строковое значение поля не может быть пустым.
    @Size(max = 50)//указывает ограничения на длину строки.
    private String lastName;

    @Pattern(regexp = "\\+7\\d{10}")// аннотация, которая указывает, что поле должно соответствовать заданному
    // регулярному выражению. В данном классе аннотация @Pattern(regexp = "\\+7\\d{10}") используется для поля
    // phone, которое должно содержать номер телефона в формате "+7" и еще 10 цифр.
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user")
    private Image avatar;

    public User(Collection<Ads> ads, Integer id, String email, String firstName, String lastName, String phone, Role role, Image avatar) {
        this.ads = ads;
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.role = role;
        this.avatar = avatar;
    }
    public User(Integer id, String email, String firstName, String lastName, String phone,Image avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.avatar = avatar;
    }

    public User(Integer id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public User() {

    }
    public Collection<Ads> getAds() {
        return ads;
    }

    public void setAds(Collection<Ads> ads) {
        this.ads = ads;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ads.equals(user.ads) && id.equals(user.id) && email.equals(user.email) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && phone.equals(user.phone) && role == user.role && avatar.equals(user.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ads, id, email, firstName, lastName, phone, role, avatar);
    }
    @Override
    public String toString() {
        return "User{" +
                "ads=" + ads +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", avatar=" + avatar +
                '}';
    }


}
