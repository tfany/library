package com.huihuitf.library.service;

import com.huihuitf.library.entity.Rank;

import java.util.List;

public interface RankService {
    int modifyRank(Rank rank);
    Rank addLevel(Rank rank);
    void deleteByLevel(Integer level);
    Rank findRankByLevel(Integer level);
    List<Rank> findAllRank();
    List<Rank> findAllRank(int pageNum,int pageSize);

}
