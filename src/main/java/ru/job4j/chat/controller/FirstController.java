package ru.job4j.chat.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.chat.model.Person;
import ru.job4j.chat.services.IPersonService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class FirstController {

    private final IPersonService serviceP;


    @GetMapping("/")
    public List<Person> findAll() {
        return StreamSupport.stream(this.serviceP.getAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable long id) {
        var person = this.serviceP.getById(id);
        return new ResponseEntity<>(person.orElse(new Person())
                , person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
