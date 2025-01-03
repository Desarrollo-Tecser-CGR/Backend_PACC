package com.pacc.base.domain.repository;

import java.util.List;

import com.pacc.base.application.user.dto.UserWithRolesRequestDto;
import com.pacc.base.infrastructure.persistence.entity.UserEntity;

public interface IUserRoleRepository {

    public abstract List<UserEntity> findAll();

    public abstract UserEntity assignRolesToUser(UserWithRolesRequestDto requestDto);

}
