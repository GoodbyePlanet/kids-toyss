package com.kidstoys.kidstoys.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidstoys.kidstoys.domain.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, String> {

}