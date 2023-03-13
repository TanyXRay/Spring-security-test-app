package ru.home.chernyadieva.springsecuritytest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Класс - модель для представления в БД в виде таблицы
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Поле - имя пользователя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя пользователя должно быть от 2 до 100 символов длиной")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Поле - год рождения пользователя не должно быть пустым")
    @Min(value = 1910, message = "Значение поля года рождения должно быть больше чем 1910")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @NotBlank(message = "Поле - пароль пользователя не должно быть пустым")
    @Column(name = "password")
    private String password;
}
