package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerDao extends JpaRepository<Manager,Long> {
}
