package com.pacc.base.application.role.usecase;

import java.util.List;

import com.pacc.base.application.role.dto.RoleRequestDto;
import com.pacc.base.infrastructure.persistence.entity.RoleEntity;

public interface IRoleService {
    public abstract List<RoleRequestDto> findAll();

    public abstract RoleRequestDto findById(Long idRole);

    public abstract RoleRequestDto create(RoleEntity roleEntity);

    public abstract RoleRequestDto update(RoleEntity roleEntity);

    public abstract RoleRequestDto activateOrDeactivate(Long idRole);
}
