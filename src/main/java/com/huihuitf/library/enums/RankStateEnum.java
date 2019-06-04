package com.huihuitf.library.enums;

import lombok.Getter;

@Getter
public enum RankStateEnum {
    SUCCESS(1001, "操作成功"),
    UPDATE_ERROR(1002, "更新失败"),
    INSERT_ERROR(1003, "插入失败"),
    NULL_LEVEL(1004,"level为空"),
    DELETE_ERROR(1005,"删除失败"),
    ADD_ERROR(1006,"添加失败");


    private int state;
    private String stateInfo;

    RankStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static RankStateEnum stateOf(int index) {
        for (RankStateEnum state : values()) {
            if (state.getState() == index)
                return state;
        }
        return null;
    }
}
