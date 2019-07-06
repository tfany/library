package com.huihuitf.library.dto;

import com.huihuitf.library.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends User {
    private Integer level;
}
