package ru.skypro.homework.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;
/**
 В классе `Ads`(Объявления) определены конструкторы для создания объектов класса,а также методы геттеров и сеттеров для доступа
 к полям. Методы `equals()`, `hashCode()` и `toString()` вызываются при сравнении, хешировании и преобразовании
 объекта в строку.
 */
@Component
@Entity//Аннотация `@Entity` используется в JPA-сущностях для обозначения, что класс представляет собой таблицу в базе данных.
//@Data//Аннотация `@Data` автоматически создает все необходимые методы геттеров, сеттеров, методы сравнения и хеширования, а также метод toString().
@Table(name = "ads")// - аннотация определяет имя таблицы в базе данных.
public class Ads {

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Min(1)//для минимального значения, которое может принимать поле
    private Integer author;
    @Id
    private Integer id;
    @NotNull// для значения, которое не может быть null,
    @Min(1)// для минимального значения, которое может принимать поле
    private Integer pk;

    @NotBlank//для значения, которое не должно быть пустой строкой
    @Size(max = 100)// для проверки размера строки,
    private String title;

    @NotNull// для значения, которое не может быть null,
    @Positive//для положительного значения
    private Integer price;


    @NotBlank//для значения, которое не должно быть пустой строкой
    @Size(max = 500)// / для проверки размера строки,
    private String image;
    private String imagePath;

    public Ads(Integer pk, Integer author, String title, Integer price, String image) {
        this.pk = pk;
        this.author = author;
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public Ads() {

    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return user.equals(ads.user) && author.equals(ads.author) && id.equals(ads.id) && pk.equals(ads.pk) && title.equals(ads.title) && price.equals(ads.price) && image.equals(ads.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, author, id, pk, title, price, image);
    }
    @Override
    public String toString() {
        return "Ads{" +
                "user=" + user +
                ", author=" + author +
                ", id=" + id +
                ", pk=" + pk +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
