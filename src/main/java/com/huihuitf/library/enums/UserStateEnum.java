package com.huihuitf.library.enums;

import lombok.Getter;

@Getter
public enum UserStateEnum {
    SUCCESS(1001, "操作成功"),
    UPDATE_ERROR(1002, "更新失败"),
    INSERT_ERROR(1003, "插入失败"),
    ID_EXIST(1007,"id已经存在"),
    NULL_USER(1004,"userId为空"),
    DELETE_ERROR(1005,"删除失败"),
    ADD_ERROR(1006,"添加失败"),
    NULL_IMG(1007,"图片为空");


    private int state;
    private String stateInfo;

    UserStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static UserStateEnum stateOf(int index) {
        for (UserStateEnum state : values()) {
            if (state.getState() == index)
                return state;
        }
        return null;
    }
}
