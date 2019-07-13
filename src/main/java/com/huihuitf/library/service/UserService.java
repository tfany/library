package com.huihuitf.library.service;

import com.huihuitf.library.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User addUser(User user, MultipartFile headImg);
    void deleteUser(Long user);
    String addFace(Long userId, MultipartFile face);
    void deleteUsers(List<User> userList);
    int modifyPasswordByUserId(Long userId,String oldPassword,String newPassword);
    int modifyInformation(User user);
    List<User> queryUser(User user);
    User queryByPhoneNum(String num);
    boolean passwordIsTrue(Long userId,String password);
    Long queryMaxUserId();
    List<User> listUser(int pageNum,int pageSize);


    int queryTotal();
}
