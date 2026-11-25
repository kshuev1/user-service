package ru.netology.users.controller;

import ru.netology.users.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Map<Long, User> users = Map.of(
            1L, new User(
                    1L,
                    "Иван Иванов",
                    "Москва, ул. Ленина, 10",
                    "+79990000001",
                    "ivan@example.com"
            ),
            2L, new User(
                    2L,
                    "Петр Петров",
                    "Москва, ул. Пушкина, 15",
                    "+79990000002",
                    "petr@example.com"
            )
    );

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        User user = users.get(userId);

        if (user == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND,
                    "User not found"
            );
        }

        return user;
    }
}