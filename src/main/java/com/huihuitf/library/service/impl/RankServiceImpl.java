package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.RankDao;
import com.huihuitf.library.entity.Rank;
import com.huihuitf.library.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public int modifyRank(Rank rank) {
        if(rankDao.existsById(rank.getLevel())){
            rankDao.save(rank);
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public Rank addLevel(Rank rank) {
        if(!rankDao.existsById(rank.getLevel())){
            return rankDao.save(rank);
        }else {
            return null;
        }
    }

    @Override
    public int deleteByLevel(Integer level) {
        try {
            rankDao.deleteById(level);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @Override
    public Rank findRankByLevel(Integer level) {
        return rankDao.findById(level).orElse(new Rank());
    }

    @Override
    public List<Rank> findAllRank() {
        return rankDao.findAll();
    }

    @Override
    public List<Rank> findAllRank(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"level");
        Pageable pageable= PageRequest.of(pageNum,pageSize, sort);
        Page<Rank> rankPage = rankDao.findAll(pageable);
        return rankPage.getContent();
    }
}
