package com.votation.api.service;

import com.votation.api.dto.user.InUser;
import com.votation.api.dto.user.OutUser;
import com.votation.api.entity.UserEntity;
import com.votation.api.mapper.UserMapper;
import com.votation.api.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //TODO: Implementar validação para o nome de usuário
    public OutUser postUser(InUser inUser) {
        var user = userMapper.map(inUser);

        return userMapper.map(userRepository.save(user));
    }

    public List<OutUser> getAllUsers() {
        return userMapper.map(userRepository.findAll());
    }

    public OutUser getUserById(UUID id) {
        var response = userRepository.findById(id);

        if (response.isEmpty()) {
            throw new ObjectNotFoundException(id, UserEntity.class.getSimpleName());
        }
        return userMapper.map(response.get());
    }

}
