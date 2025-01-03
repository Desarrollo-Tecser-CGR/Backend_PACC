package com.pacc.base.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pacc.base.domain.repository.IRoleRepository;
import com.pacc.base.infrastructure.exception.customException.ResourceNotFoundException;
import com.pacc.base.infrastructure.persistence.entity.RoleEntity;
import com.pacc.base.infrastructure.persistence.repository.role.IRoleRepositoryJpa;

@Component
public class RoleRepositoryAdapterImpl implements IRoleRepository {

    private final IRoleRepositoryJpa roleRepositoryJpa;

    public RoleRepositoryAdapterImpl(IRoleRepositoryJpa roleRepositoryJpa) {
        this.roleRepositoryJpa = roleRepositoryJpa;
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleEntity> findAll() {
        return this.roleRepositoryJpa.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public RoleEntity findById(Long idRole) {
        return this.roleRepositoryJpa.findById(idRole)
                .orElseThrow(() -> new ResourceNotFoundException("el rol con id=" + idRole + " no existe"));
    }

    @Transactional
    @Override
    public RoleEntity create(RoleEntity roleEntity) {
        roleEntity.setId(null);
        return this.roleRepositoryJpa.save(roleEntity);
    }

    @Transactional
    @Override
    public RoleEntity update(RoleEntity roleEntity) {
        Optional<RoleEntity> roleOptional = this.roleRepositoryJpa.findById(roleEntity.getId());
        if (roleOptional.isPresent())
            return this.roleRepositoryJpa.save(roleEntity);
        else
            throw new ResourceNotFoundException("el rol con id=" + roleEntity.getId() + " no existe");

    }

    @Transactional
    @Override
    public RoleEntity activateOrDeactivate(Long idRole) {
        RoleEntity roleEntity = this.roleRepositoryJpa.findById(idRole).orElseThrow(
                () -> new ResourceNotFoundException("el rol con id=" + idRole + " no existe"));

        if (roleEntity.isEnable())
            roleEntity.setEnable(false);
        else
            roleEntity.setEnable(true);

        return roleEntity;
    }

}