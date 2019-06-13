package com.huihuitf.library.service;

import com.huihuitf.library.dto.UserExecution;
import com.huihuitf.library.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    UserExecution addUser(User user, MultipartFile headImg);

    UserExecution deleteUser(User user);
    UserExecution deleteUsers(List<User> userList);

    UserExecution modifyPasswordByUserId(Long userId,String oldPassword,String newPassword);
    UserExecution modifyInformation(User newUser);

    UserExecution queryUserById(Long userId);
    UserExecution queryUserByName(String name);

    Long queryMaxUserId();

}
