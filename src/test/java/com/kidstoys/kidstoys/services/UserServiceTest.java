package com.kidstoys.kidstoys.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kidstoys.kidstoys.domain.User;
import com.kidstoys.kidstoys.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void should_get_all_users() {
        when(userRepository.findAll()).thenReturn(List.of(User.builder().name("Pero").email("pero@gmail.com")
            .build(), User.builder().name("Jovan").email("jovan@gmail.com").build()));

        List<User> users = userService.getUsers();

        assertThat(users).hasSize(2);
    }

    @Test
    void should_save_user() {
        userService.save(any(User.class));

        verify(userRepository).save(any());
    }

}