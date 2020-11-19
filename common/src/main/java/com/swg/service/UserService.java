package com.swg.service;

import com.swg.domain.User;
import com.swg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUserNo(Long _userNo) {
        Optional<User> user = userRepository.findById(_userNo);
        return user;
    }
}
