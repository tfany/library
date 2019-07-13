package com.huihuitf.library.dao;

import com.huihuitf.library.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryDao extends JpaRepository<History,String> {
    List<History> findHistoriesByUser_UserId(Long user_userId);
}
