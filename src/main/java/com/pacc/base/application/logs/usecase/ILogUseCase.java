package com.pacc.base.application.logs.usecase;

import java.util.List;

import com.pacc.base.application.auth.dto.AuthRequestDto;
import com.pacc.base.application.logs.dto.LogDto;
import com.pacc.base.infrastructure.persistence.entity.LogEntity;

public interface ILogUseCase {
    public abstract List<LogDto> logFindAll();

    public abstract LogEntity createLog(AuthRequestDto userRequest);
}
