package ru.job4j.chat.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Person;
import ru.job4j.chat.repositories.PersonRepository;

import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PersonService implements IPersonService {

    @Autowired
    private final PersonRepository personR;
    private static Logger log = Logger.getLogger(PersonService.class.getName());


    @Override
    public Iterable<Person> getAll() {
        log.info("Person get All");
        personR.findAll();
        return personR.findAll();
    }

    @Override
    public Optional<Person> getById(Long id) {
        personR.findById(id);
        return personR.findById(id);
    }

    @Override
    public Person save(Person person) {
        return personR.save(person);
    }
}
