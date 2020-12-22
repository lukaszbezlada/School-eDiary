package com.lukaszbezlada.studentdiary.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@Component
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 6359254733772657789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Pattern(regexp = "^[\\p{Alnum}]{3,10}$")
    private String login;

    @Column
    @NotEmpty
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

    public User(Long id, @Pattern(regexp = "^[\\p{Alnum}]{3,10}$") String login, @NotEmpty String password, String password2, @Pattern(regexp = "^[\\p{Alnum}]{3,10}$") String firstName, @Pattern(regexp = "^[\\p{Alnum}]{3,20}$") String lastName, @Email @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") String email, Set<UserRole> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.password2 = password2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}