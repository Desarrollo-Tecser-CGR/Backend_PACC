package com.pacc.base.domain.repository;

import java.util.List;

import com.pacc.base.infrastructure.persistence.entity.UserEntity;

public interface IActiveDirectoryUserRepository {
    Boolean checkAccount(String samAccountName, String password);

    List<UserEntity> getAllUsers();
}
