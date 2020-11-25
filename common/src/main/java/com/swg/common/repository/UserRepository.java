package com.swg.common.repository;

import com.swg.common.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserNo(Long _userNo);
}
