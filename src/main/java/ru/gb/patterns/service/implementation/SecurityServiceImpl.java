package ru.gb.patterns.service.implementation;

import org.springframework.stereotype.Service;
import ru.gb.patterns.model.User;
import ru.gb.patterns.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Override
    public User getCurrentUser() {
        User mockUser = new User();
        mockUser.setEmail("test@email.io");
        mockUser.setPassword("password");
        mockUser.setFirstName("Thomas");
        mockUser.setLastName("Anderson");
        return mockUser;
    }

}
