package com.kidstoys.kidstoys.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kidstoys.kidstoys.domain.User;
import com.kidstoys.kidstoys.services.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/api/users")
@AllArgsConstructor
@Log4j2
public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        log.info("Getting list of users");
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("Saving a new user...");
        userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "/hellou")
    public ResponseEntity<String> hello() {
        log.info("inside hello method");
        return ResponseEntity.ok("Hellou from kids toys");
    }
}
