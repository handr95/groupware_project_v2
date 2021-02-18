package com.sgw.web.service;


import com.sgw.common.domain.UserSession;
import com.sgw.common.service.UserService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final UserService userService;
    private final HttpSession httpSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.sgw.common.domain.User> memberEntityWrapper = userService.findByNickNm(username);
        com.sgw.common.domain.User userEntity = memberEntityWrapper.orElse(null);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userEntity.getRole().getKey()));

        UserSession userSession = new UserSession(userEntity);
        httpSession.setAttribute("userSession", userSession);
        return new User(userEntity.getNickNm(), userEntity.getPwd(), authorities);
    }
}
