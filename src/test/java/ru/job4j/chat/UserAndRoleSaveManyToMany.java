package ru.job4j.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.job4j.chat.model.User;
import ru.job4j.chat.model.Role;
import ru.job4j.chat.repositories.PersonRepository;
import ru.job4j.chat.repositories.RoleRepository;
import ru.job4j.chat.services.PersonService;
import ru.job4j.chat.services.RoleService;


import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest(classes = ChatApplication.class)
public class UserAndRoleSaveManyToMany {
    private static Logger log = Logger.getLogger(UserAndRoleSaveManyToMany.class.getName());

    @Autowired
    private PersonRepository repository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PersonService personService;
    @Autowired
    RoleService roleService;

    User user1;
    User user;
    Role role;
    Role role1;

    @BeforeEach
    void setUp() {

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
        User person = personService.getById(1L);
        Collection personList = (Collection) personService.getAll();

        assertAll("We can get values using Service",
                () -> System.out.println(person.toString() + " Test We can get from DB value"),
                () -> assertThat(person).isNotNull(),
                () -> assertThat(personList).isNotEmpty(),
                () -> personList.forEach(System.out::println));
    }
}
