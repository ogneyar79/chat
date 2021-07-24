package ru.job4j.chat.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {

    private Long id;
    private String firstName;
    private String lastName;
}
