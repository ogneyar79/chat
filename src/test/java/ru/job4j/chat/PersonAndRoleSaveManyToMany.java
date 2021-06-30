package ru.job4j.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.job4j.chat.model.Person;
import ru.job4j.chat.model.Role;
import ru.job4j.chat.repositories.PersonRepository;
import ru.job4j.chat.repositories.RoleRepository;
import ru.job4j.chat.services.PersonService;
import ru.job4j.chat.services.RoleService;


import java.util.Optional;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest(classes = ChatApplication.class)
public class PersonAndRoleSaveManyToMany {
    private static Logger log = Logger.getLogger(PersonAndRoleSaveManyToMany.class.getName());

    @Autowired
    private PersonRepository repository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PersonService personService;
    @Autowired
    RoleService roleService;

    Person person1;
    Person person;
    Role role;
    Role role1;

    @BeforeEach
    void setUp() {
        role = new Role("ROLE_USER");
        role1 = new Role("ROLE_ROOM1");
        person1 = new Person("Olga", "o@mail.ru", "4567");
        person = new Person("Ivan", "i@mail.ru", "4568");
        person.addRoleForPerson(role);
        person1.addRoleForPerson(role);
        person1.addRoleForPerson(role1);
    }

    @Test
    @DisplayName("Checking that test work")
    public void contextLoads() throws Exception {
        assertThat(personService).isNotNull();
        assertAll("NotNull Service",
                () -> assertThat(personService).isNotNull(),
                () -> assertThat(roleService).isNotNull());
    }
    @Test
    @DisplayName("test That service is work Work correctly")
    public void shouldReturnAllPersons() throws Exception {
        log.info("Beginning Test");
        personService.getById(1L);
        Optional<Person> person = personService.getById(1L);
        Iterable<Person> personList = personService.getAll();
        assertAll("We can get values using Service",
                () -> System.out.println(person.get().toString() + " Test We can get from DB value"),
                () -> assertThat(person.get()).isNotNull(),
                () -> assertThat(personList).isNotEmpty(),
                () -> personList.forEach(System.out::println));
    }
}
