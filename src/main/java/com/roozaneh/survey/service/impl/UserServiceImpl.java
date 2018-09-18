package com.roozaneh.survey.service.impl;


import com.roozaneh.survey.domain.User;
import com.roozaneh.survey.repository.UserRepository;
import com.roozaneh.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public int save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void createUser(String username, String password, String role) {
        User user = new User(username,
                passwordEncoder.encode(password)
                ,"ROLE_"+role,"true");
        userRepository.saveAndFlush(user);
    }
}
