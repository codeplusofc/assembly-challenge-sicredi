package com.votation.api.mapper;

import com.votation.api.dto.user.InUser;
import com.votation.api.dto.user.OutUser;
import com.votation.api.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserEntity map(InUser inUser);

    public abstract OutUser map(UserEntity userEntity);

    public abstract List<OutUser> map(List<UserEntity> userEntities);
}
