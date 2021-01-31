package com.lukaszbezlada.studentdiary.controller;

import com.lukaszbezlada.studentdiary.entity.User;
import com.lukaszbezlada.studentdiary.repository.UserRepository;
import com.lukaszbezlada.studentdiary.service.UserDTO;
import com.lukaszbezlada.studentdiary.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;
    private final UserDTOService userDTOService;

    @Autowired
    public UserController(UserRepository userRepository, UserDTOService userService) {
        this.userRepository = userRepository;
        this.userDTOService = userService;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> allUsers() {
        List<User> allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping(path = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return ResponseEntity.ok(user.get());
    }

    @PostMapping(path = "/addUser")
    public void saveUser(@RequestBody UserDTO userDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
        }
        userDTOService.addSuitableUserWithEncryptedPassword(userDTO);
    }
}
