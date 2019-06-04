package com.huihuitf.library.service.impl;

import com.huihuitf.library.Exception.RankException;
import com.huihuitf.library.dao.RankDao;
import com.huihuitf.library.dto.RankExecution;
import com.huihuitf.library.entity.Rank;
import com.huihuitf.library.service.RankService;
import com.huihuitf.library.enums.RankStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RankServiceImpl implements RankService {
    @Autowired
    private RankDao rankDao;

    @Override
    public RankExecution modifyRank(Rank rank) {
        if (rank == null || rank.getLevel() == null) {
            return new RankExecution(RankStateEnum.NULL_LEVEL);
        } else {
            try {
                if (!rankDao.existsById(rank.getLevel())) {
                    return new RankExecution(RankStateEnum.UPDATE_ERROR);
                }
                int effectedNum = rankDao.updateDiscountByLevel(rank.getDiscount(), rank.getLevel()) +
                        rankDao.updateNameByLevel(rank.getName(), rank.getLevel());
                if (effectedNum <= 0) {
                    return new RankExecution(RankStateEnum.UPDATE_ERROR);
                }
                return new RankExecution(RankStateEnum.SUCCESS, rank);
            } catch (Exception e) {
               throw new RankException("更新错误"+e.getMessage()+e.getMessage());
            }
        }
    }

    @Override
    public RankExecution deleteByLevel(Integer level) {
        Rank rank=new Rank();
        rank.setLevel(level);
        if(level==null){
            return new RankExecution(RankStateEnum.DELETE_ERROR);
        }
        if(rankDao.existsById(level)) {
            try {
                rankDao.deleteById(level);
                return new RankExecution(RankStateEnum.SUCCESS,rank);
            } catch (Exception e) {
                throw new RankException("删除出错"+e.getMessage());
            }
        }else {
            return new RankExecution(RankStateEnum.DELETE_ERROR);
        }
    }

    @Override
    public RankExecution addLevel(Rank rank) {
        if (rank == null || rank.getLevel() == null) {
            return new RankExecution(RankStateEnum.INSERT_ERROR);
        } else {
            try {
                if (rankDao.existsById(rank.getLevel())) {
                    return new RankExecution(RankStateEnum.INSERT_ERROR);
                }
                Rank addRank = rankDao.save(rank);
                return new RankExecution(RankStateEnum.SUCCESS, addRank);
            }catch (Exception e){
                throw new RankException("插入错误"+e.getMessage());
            }
        }
    }

    @Override
    public RankExecution findRankByLevel(Integer level) {
        if(level==null){
            return new RankExecution(RankStateEnum.NULL_LEVEL);
        }
        try {
            Rank rank = rankDao.findById(level).orElse(null);
            return new RankExecution(RankStateEnum.SUCCESS,rank);
        }catch (Exception e){
            throw new RankException("查询出错"+e.getMessage());
        }
    }

    @Override
    public RankExecution findAllRank() {
        try {
            List<Rank> rankList=rankDao.findAll(new Sort(Sort.Direction.DESC, "level"));
            return new RankExecution(RankStateEnum.SUCCESS,rankList);
        }catch (Exception e){
            throw new RankException("查询全部出错"+e.getMessage());
        }

    }
}
