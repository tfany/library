package com.huihuitf.library.dto;

import com.huihuitf.library.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    public UserDto() {
    }
    public UserDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.phoneNum = user.getPhoneNum();
        this.createTime = user.getCreateTime();
        this.updateTime = user.getUpdateTime();
        this.status = user.getStatus();
    }

    private Long userId;
    private String name;
    private String gender;
    private String phoneNum;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
