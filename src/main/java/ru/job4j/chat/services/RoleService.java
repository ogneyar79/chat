package ru.job4j.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Role;
import ru.job4j.chat.repositories.RoleRepository;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private final RoleRepository roleRepositorys;
    private static Logger log = Logger.getLogger(RoleService.class.getName());

    public RoleService(RoleRepository roleRepositorys) {
        this.roleRepositorys = roleRepositorys;
    }


    @Override
    public Iterable<Role> getAll() {
        return roleRepositorys.findAll();
    }

    @Override
    public Optional<Role> getById(Long id) {
        return roleRepositorys.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepositorys.save(role);
    }
}
