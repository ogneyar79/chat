package ru.job4j.chat.services;

import ru.job4j.chat.model.User;
import ru.job4j.chat.model.Role;

import java.util.Optional;

public interface IPersonService {

    Iterable<User> getAll();

    User getById(Long id);

    public boolean deleteUser(Long userId);
    boolean save(User user);

    User savePersonWithRole(User p, Role r);

}
