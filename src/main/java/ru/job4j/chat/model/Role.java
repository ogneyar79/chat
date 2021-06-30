package ru.job4j.chat.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"authority"})
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "authority")
    private String roleName;


    public Role(String roleName) {
        this.roleName = roleName;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> persons = new ArrayList<>();

    public void addPersonToRole(Person p) {
        if (persons == null) {
            persons = new ArrayList<>();
            persons.add(p);
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", authority='" + roleName + '\'' +
                '}';
    }
}
