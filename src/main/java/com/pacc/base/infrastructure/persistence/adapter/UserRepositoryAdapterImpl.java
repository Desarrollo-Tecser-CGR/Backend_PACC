package com.pacc.base.infrastructure.persistence.adapter;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pacc.base.application.user.dto.UserWithRolesRequestDto;
import com.pacc.base.domain.repository.IUserRoleRepository;
import com.pacc.base.infrastructure.exception.customException.ResourceNotFoundException;
import com.pacc.base.infrastructure.persistence.entity.RoleEntity;
import com.pacc.base.infrastructure.persistence.entity.UserEntity;
import com.pacc.base.infrastructure.persistence.repository.role.IRoleRepositoryJpa;
import com.pacc.base.infrastructure.persistence.repository.user.IUserRepositoryJpa;

@Component
public class UserRepositoryAdapterImpl implements IUserRoleRepository {

    private final IUserRepositoryJpa userRepositoryJpa;

    private final IRoleRepositoryJpa roleRepositoryJpa;

    public UserRepositoryAdapterImpl(IUserRepositoryJpa userRepositoryJpa, IRoleRepositoryJpa roleRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
        this.roleRepositoryJpa = roleRepositoryJpa;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = this.userRepositoryJpa.findAll();
        return users;
    }

    @Transactional
    @Override
    public UserEntity assignRolesToUser(UserWithRolesRequestDto requestDto) {
        UserEntity user = this.userRepositoryJpa.findById(requestDto.getIdUser())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "el usuario con id=" + requestDto.getIdUser() + " no existe"));

        List<RoleEntity> roles = this.roleRepositoryJpa.findByIdIn(requestDto.getRoleIds());
        user.setRoles(roles);
        return this.userRepositoryJpa.save(user);
    }

}
