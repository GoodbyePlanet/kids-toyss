package com.kidstoys.kidstoys.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kidstoys.kidstoys.domain.User;
import com.kidstoys.kidstoys.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
