package com.pacc.base.domain.repository;

import java.util.List;

import com.pacc.base.infrastructure.persistence.entity.LogEntity;

public interface ILogRepository {

    public abstract List<LogEntity> logFindAll();

    public abstract LogEntity createLog(LogEntity logEntity, String userName);

}
