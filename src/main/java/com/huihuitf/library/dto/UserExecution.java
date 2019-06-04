package com.huihuitf.library.dto;

import com.huihuitf.library.entity.User;
import com.huihuitf.library.enums.UserStateEnum;
import lombok.Data;

import java.util.List;

@Data
public class UserExecution {
    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    private User user;

    private List<User> userList;

    public UserExecution() {
    }

    //失败时的构造器
    public UserExecution(UserStateEnum stateEnum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }

    //成功时的构造器
    public UserExecution(UserStateEnum stateEnum, User user){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.user=user;
    }

    public UserExecution(UserStateEnum stateEnum, List<User> userList){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.userList=userList;
    }

}
