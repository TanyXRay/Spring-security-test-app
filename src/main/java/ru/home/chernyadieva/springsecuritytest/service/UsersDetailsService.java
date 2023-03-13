package ru.home.chernyadieva.springsecuritytest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.chernyadieva.springsecuritytest.model.Users;
import ru.home.chernyadieva.springsecuritytest.repository.UsersRepository;
import ru.home.chernyadieva.springsecuritytest.security.UsersDetails;

import java.util.Optional;

/**
 * Класс сервисного слоя для работы с БД (для работы с security) - сервис загружает пользователя.
 * Реализуем спец. для этого интерфейс UserDetailsService и переопределяем главный метод загрузки пользователя из БД
 */
@Service
@Transactional(readOnly = true)
public class UsersDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = usersRepository.findByUsername(username);

        if (users.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }
        return new UsersDetails(users.get());
    }
}
