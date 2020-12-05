package com.swg.common.repository;

import com.swg.common.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUserNo(Long _userNo);
    public Optional<User> findByNickNm(String _nickNm);
}
