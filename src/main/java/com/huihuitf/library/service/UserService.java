package com.huihuitf.library.service;

import com.huihuitf.library.dto.UserDto;
import com.huihuitf.library.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User addUser(User user, MultipartFile headImg);

    void deleteUser(User user);
    void deleteUsers(List<User> userList);

    int modifyPasswordByUserId(Long userId,String oldPassword,String newPassword);
    int modifyInformation(User user);

    List<UserDto> queryUser(User user);

    boolean passwordIsTrue(Long userId,String password);
    Long queryMaxUserId();

}
