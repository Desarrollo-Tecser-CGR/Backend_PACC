package com.pacc.base.infrastructure.persistence.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacc.base.infrastructure.persistence.entity.Menu.Menu;

public interface IMenuRepositoryJpa extends JpaRepository<Menu,Long> {


}
