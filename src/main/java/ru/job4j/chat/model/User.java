package ru.job4j.chat.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @Size(min=2, message = "Не меньше 5 знаков")
    private String email;

    @Column(name = "password")
    @Size(min=2, message = "Не меньше 5 знаков")
    private String password;

    @Column(name = "username")
    @Size(min=2, message = "Не меньше 5 знаков")
    private String firstName;

    @Column(name = "last_name")
    @Size(min=2, message = "Не меньше 5 знаков")
    private String lastName;

    private boolean enabled;

    @Transient
    private String passwordConfirm;

    @Column(name = "token_ex")
    private boolean tokenExpired;

    public void addRoleForPerson(Role role){
        this.roles.add(role);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "authority_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    // possible use email?
    @Override
    public String getUsername() {
        return firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}