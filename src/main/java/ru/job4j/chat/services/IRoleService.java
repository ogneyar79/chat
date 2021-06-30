package ru.job4j.chat.services;

import ru.job4j.chat.model.Person;
import ru.job4j.chat.model.Role;

import java.util.Optional;

public interface IRoleService {

    Iterable<Role> getAll();

    Optional<Role> getById(Long id);

    Role save(Role role);

}
