package com.smartbooking.user.application;

import com.smartbooking.user.domain.User;
import com.smartbooking.user.infrastructure.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void shouldRegisterUserSuccessfully() {
        InMemoryUserRepository repo = new InMemoryUserRepository();
        UserService service = new UserService(repo);

        User user = service.register("hosni", "hosni@example.com");

        assertNotNull(user);
        assertEquals("hosni", user.getUsername());
        assertEquals("hosni@example.com", user.getEmail());
        assertEquals(1, repo.findAll().size());
    }

    @Test
    void shouldThrowExceptionForInvalidEmail() {
        InMemoryUserRepository repo = new InMemoryUserRepository();
        UserService service = new UserService(repo);

        assertThrows(IllegalArgumentException.class, () ->
                service.register("hosni", "invalidEmail")
        );
    }
}
