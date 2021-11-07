package com.kidstoys.kidstoys.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kidstoys.kidstoys.RepositoryTestConfig;
import com.kidstoys.kidstoys.domain.User;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserRepositoryTest extends RepositoryTestConfig {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void should_not_find_users_if_repository_is_empty() {
        List<User> users = userRepository.findAll();

        assertThat(users).isEmpty();
    }

    @Test
    void should_find_users_if_repository_is_not_empty() {
        User userOne = User.builder().name("user_one").email("user_one@user.com").build();
        User userTwo = User.builder().name("user_two").email("user_two@user.com").build();
        entityManager.persist(userOne);
        entityManager.persist(userTwo);

        List<User> users = userRepository.findAll();

        assertThat(users).hasSize(2).contains(userOne, userTwo);
    }

    @Test
    void should_save_user() {
        User savedUser = userRepository.save(User.builder().name("user_one").email("user_one@user.com").build());

        assertThat(savedUser).hasFieldOrPropertyWithValue("name", "user_one");
        assertThat(savedUser).hasFieldOrPropertyWithValue("email", "user_one@user.com");
    }
}