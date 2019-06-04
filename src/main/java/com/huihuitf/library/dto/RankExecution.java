package com.huihuitf.library.dto;

import com.huihuitf.library.entity.Rank;
import com.huihuitf.library.enums.RankStateEnum;
import lombok.Data;

import java.util.List;

@Data
public class RankExecution {
    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    private Rank rank;

    private List<Rank> rankList;

    public RankExecution() {
    }

    //失败时的构造器
    public RankExecution(RankStateEnum stateEnum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }

    //成功时的构造器
    public RankExecution(RankStateEnum stateEnum,Rank rank){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.rank=rank;
    }

    //成功时的构造器
    public RankExecution(RankStateEnum stateEnum,List<Rank> rankList){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.rankList=rankList;
    }
}
