package com.example.postgresql.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.postgresql.model.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {}
