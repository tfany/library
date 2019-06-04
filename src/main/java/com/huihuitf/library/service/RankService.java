package com.huihuitf.library.service;

import com.huihuitf.library.dto.RankExecution;
import com.huihuitf.library.entity.Rank;

import java.util.List;

public interface RankService {
    RankExecution modifyRank(Rank rank);
    RankExecution addLevel(Rank rank);
    RankExecution deleteByLevel(Integer level);
    RankExecution findRankByLevel(Integer level);
    RankExecution findAllRank();

}
