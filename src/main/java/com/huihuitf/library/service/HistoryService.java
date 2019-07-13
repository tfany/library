package com.huihuitf.library.service;

import com.huihuitf.library.dto.HistoryDto;
import com.huihuitf.library.entity.History;

import java.util.List;

public interface HistoryService {
    History add(HistoryDto historyDto);
    List<History> findAllBook(int pageNum,int pageSize);
    int queryTotal();
    List<History> findBookByUserId(Long id);
    boolean huan(String id);
}
