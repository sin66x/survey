package com.roozaneh.survey.service.impl;


import com.roozaneh.survey.domain.User;
import com.roozaneh.survey.repository.UserRepository;
import com.roozaneh.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public int save(User user) {
        userRepository.save(user);
        return user.getId();
    }
}
