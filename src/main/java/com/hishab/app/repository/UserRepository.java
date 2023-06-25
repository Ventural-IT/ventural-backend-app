package com.hishab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hishab.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
