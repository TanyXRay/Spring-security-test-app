package ru.home.chernyadieva.springsecuritytest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.home.chernyadieva.springsecuritytest.security.UsersDetails;
import ru.home.chernyadieva.springsecuritytest.service.UsersDetailsService;

import java.util.Collections;

/**
 * Провайдер аутентификации для конфигурации spring security,
 * внедряем в SecurityConfig класс
 */
@Component
public class AuthProviderImpl implements AuthenticationProvider {
    private final UsersDetailsService usersDetailsService;

    @Autowired
    public AuthProviderImpl(UsersDetailsService usersDetailsService) {
        this.usersDetailsService = usersDetailsService;
    }

    /**
     * Основной метод - проверяет аутентификацию пользователя
     * Объект, который возвращается, будет храниться в сессии
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();

        UsersDetails usersDetails = usersDetailsService.loadUserByUsername(username);
        String password = authentication.getCredentials().toString();
        if (!password.equals(usersDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        return new UsernamePasswordAuthenticationToken(usersDetails, password, Collections.emptyList());// в списке указываются права пользователя
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
