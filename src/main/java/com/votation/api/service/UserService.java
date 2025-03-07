package com.votation.api.service;

import com.votation.api.entity.UserEntity;
import com.votation.api.exception.BadRequestException;
import com.votation.api.exception.ForbiddenException;
import com.votation.api.repository.UserRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity postUser(UserEntity userEntity){
        if (userEntity.getName().isEmpty()) {
            throw new BadRequestException("Blank name, invalid");
        }

        return userRepository.save(userEntity);
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

    public void deletById(UUID id) {
        throw new ForbiddenException("FORBIDDEN REQUEST");
    }
}
