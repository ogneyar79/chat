package ru.job4j.chat.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.chat.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {



}
