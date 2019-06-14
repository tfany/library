package com.huihuitf.library.service.impl;

import com.huihuitf.library.entity.Rank;
import com.huihuitf.library.service.RankService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class RankServiceImplTest {

    @Autowired
    private RankService rankService;
    @Test
    public void modifyRank() {
        Rank rank=new Rank();
        rank.setLevel(1);
        rank.setName("假的会员");
        rank.setDiscount(1D);
        int re= rankService.modifyRank(rank);
        Assert.assertEquals(1,re);
    }

    @Test
    public void addLevel() {
        Rank rank=new Rank();
        rank.setLevel(7);
        rank.setDiscount(0.01);
        rank.setName("至尊会员");
        Rank rankExecution=rankService.addLevel(rank);
        System.out.println(rankExecution);
    }

    @Test
    public void findRankByLevel() {
        Rank rank=rankService.findRankByLevel(1);
        System.out.println(rank);
    }

    @Test
    public void findAllRank() {
        List<Rank> rankList=rankService.findAllRank();
        System.out.println(rankList);
    }

    @Test
    public void deleteByLevel(){
        rankService.deleteByLevel(7);
    }
}