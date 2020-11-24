package com.swg.repository;

import com.swg.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserNo(Long _userNo);
}
