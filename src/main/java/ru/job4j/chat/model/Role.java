package ru.job4j.chat.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "authority")
    private String roleName;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    @Transient
    private Set<User> users;

    public void setPrivilege(Privilege p) {
        this.privileges.add(p);
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }


    public Role(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
