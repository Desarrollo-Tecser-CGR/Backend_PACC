package com.pacc.base.domain.repository;

import java.util.List;

import com.pacc.base.infrastructure.persistence.entity.RoleEntity;

public interface IRoleRepository {

    public abstract List<RoleEntity> findAll();

    public abstract RoleEntity findById(Long idRole);

    public abstract RoleEntity create(RoleEntity roleEntity);

    public abstract RoleEntity update(RoleEntity roleEntity);

    public abstract RoleEntity activateOrDeactivate(Long idRole);

}
