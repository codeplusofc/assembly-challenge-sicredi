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

    //TODO: Implementar validação para o nome de usuário
    public OutUser postUser(InUser userInput) {
        var user = userMapper.map(userInput);

        return userMapper.map(userRepository.save(user));
    }

    //TODO: Utilizar a camada de Mapper nesta funcionalidade
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    //TODO: Utilizar a camada de Mapper nesta funcionalidade
    public UserEntity getUserById(UUID id) {
        var response = userRepository.findById(id);
        if (response.isEmpty()) {
            throw new ObjectNotFoundException(id, UserEntity.class.getSimpleName());
        }
        return response.get();
    }

}
