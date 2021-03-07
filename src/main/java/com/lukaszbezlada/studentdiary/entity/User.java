package com.lukaszbezlada.studentdiary.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@Component
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 6359254733772657789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Pattern(regexp = "^[\\p{Alnum}]{3,10}$")
    private String login;

    @Column
    @NotNull
    private String password;

    @Transient
    private String password2;

    @Column
    @Pattern(regexp = "^[\\p{Alnum}]{3,10}$")
    private String firstName;

    @Column
    @Pattern(regexp = "^[\\p{Alnum}]{3,20}$")
    private String lastName;

    @Column
    @Email
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    public User() {
        //for Spring Data JPA
    }

    public User(@Pattern(regexp = "^[\\p{Alnum}]{3,10}$") String login, @NotNull String password, @Pattern(regexp = "^[\\p{Alnum}]{3,10}$") String firstName, @Pattern(regexp = "^[\\p{Alnum}]{3,20}$") String lastName, @Email @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") String email, Set<UserRole> roles) {
        this.login = login;
        this.password = password;
        this.password2 = password2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(password2, user.password2) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, password2, firstName, lastName, email, roles);
    }
}

