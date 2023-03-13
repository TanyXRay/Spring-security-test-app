package ru.home.chernyadieva.springsecuritytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.chernyadieva.springsecuritytest.model.Users;

import java.util.Optional;

/**
 * Интерфейс - репозиторий,
 * нужен для реализации JPA (запросы в БД),
 * внедрен в класс сервисного слоя для сущности Users
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
