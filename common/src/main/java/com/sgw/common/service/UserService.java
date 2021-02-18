package com.sgw.common.service;

import com.sgw.common.domain.User;
import com.sgw.common.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserNo(Long _userNo) {
        Optional<User> user = userRepository.findByUserNo(_userNo);
        return user;
    }

    public Optional<User> findByNickNm(String _nickNm) {
        Optional<User> user = userRepository.findByNickNm(_nickNm);
        return user;
    }

    public User save(User _user) {
        User user = userRepository.save(_user);
        return user;
    }
}
