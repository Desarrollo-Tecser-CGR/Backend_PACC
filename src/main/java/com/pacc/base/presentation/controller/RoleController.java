package com.pacc.base.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacc.base.application.role.dto.RoleRequestDto;
import com.pacc.base.application.role.usecase.IRoleService;
import com.pacc.base.infrastructure.persistence.entity.RoleEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController extends AbstractController {

    private IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return requestResponse(this.roleService.findAll(), "roles del sistema", HttpStatus.OK, true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return requestResponse(this.roleService.findById(id), "rol encontrado", HttpStatus.OK, true);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RoleEntity role, BindingResult result) {
        return requestResponse(result, () -> this.roleService.create(role), "rol creado", HttpStatus.CREATED, true);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody RoleEntity role, BindingResult result) {
        return requestResponse(result, () -> this.roleService.update(role), "rol actualizado", HttpStatus.OK, true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        RoleRequestDto role = this.roleService.activateOrDeactivate(id);
        return requestResponse(role, role.isEnable() ? "rol activado" : "rol desactivado", HttpStatus.OK, true);
    }

}
