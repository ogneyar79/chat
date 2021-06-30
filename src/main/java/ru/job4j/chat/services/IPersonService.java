package ru.job4j.chat.services;

import ru.job4j.chat.model.Person;
import ru.job4j.chat.model.Role;

import java.util.Optional;

public interface IPersonService {

    Iterable<Person> getAll();

    Optional<Person> getById(Long id);
    Person save(Person person);
}
