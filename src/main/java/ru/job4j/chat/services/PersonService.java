package ru.job4j.chat.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.User;
import ru.job4j.chat.model.Role;
import ru.job4j.chat.repositories.PersonRepository;
import ru.job4j.chat.repositories.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PersonService implements IPersonService, UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private final PersonRepository personR;
    private static Logger log = Logger.getLogger(PersonService.class.getName());

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Iterable<User> getAll() {
        log.info("Person get All");
        return personR.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional<User> userFromDb = personR.findById(id);
        return userFromDb.orElse(new User());
    }

    @Override
    public boolean save(User user) {
        User userFromDB = personR.findByEmail(user.getEmail());
        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        personR.save(user);
        return true;
    }

    @Override
    public User savePersonWithRole(User p, Role r) {
        p.addRoleForPerson(r);
        return personR.save(p);
    }

    @Override
    public boolean deleteUser(Long userId) {
        if (personR.findById(userId).isPresent()) {
            personR.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = personR.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
