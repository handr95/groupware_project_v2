package com.swg.common.service;

import com.swg.common.domain.User;
import com.swg.common.repository.UserRepository;

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
        Optional<User> user = userRepository.findById(_userNo);
        return user;
    }

    public User save(User _user) {
        User user = userRepository.save(_user);
        return user;
    }
}
