package com.votation.api.service;

import com.votation.api.dto.user.InUser;
import com.votation.api.dto.user.OutUser;
import com.votation.api.entity.UserEntity;
import com.votation.api.mapper.UserMapper;
import com.votation.api.repository.UserRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public OutUser postUser(InUser userInput) {
        var user = userMapper.inUserEntityDtoToUserEntity(userInput);

        return userMapper.outUserEntityDtoToUserEntity(userRepository.save(user));
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(UUID id) {
        var response = userRepository.findById(id);
        if (response.isEmpty()) {
            throw new ObjectNotFoundException(id, UserEntity.class.getSimpleName());
        }
        return response.get();
    }

}
