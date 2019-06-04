package com.huihuitf.library.service.impl;

import com.huihuitf.library.Exception.UserException;
import com.huihuitf.library.dao.UserDao;
import com.huihuitf.library.dto.UserExecution;
import com.huihuitf.library.entity.User;
import com.huihuitf.library.service.UserService;
import com.huihuitf.library.enums.UserStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserExecution addUser(User user) {
        if (user == null || user.getUserId() == null) {
            return new UserExecution(UserStateEnum.NULL_USER);
        }
        try {
            if (userDao.existsById(user.getUserId())) {
                return new UserExecution(UserStateEnum.ID_EXIST);
            }

            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());

            if (userDao.save(user) != null)
                return new UserExecution(UserStateEnum.SUCCESS, user);
            return new UserExecution(UserStateEnum.ADD_ERROR);
        } catch (Exception e) {
            throw new UserException("增加出错" + e.getMessage());
        }

    }

    @Override
    public UserExecution addUsers(List<User> userList) {
        if (userList == null) {
            return new UserExecution(UserStateEnum.NULL_USER);
        }
        try {
            List<User> userSuccessList = new ArrayList<>();
            for (User u : userList) {
                u.setCreateTime(new Date());
                u.setUpdateTime(new Date());
                if (u.getUserId() != null)
                    userSuccessList.add(userDao.save(u));
            }
            return new UserExecution(UserStateEnum.SUCCESS, userSuccessList);
        } catch (Exception e) {
            throw new UserException("增加失败" + e.getMessage());
        }
    }

    @Override
    public UserExecution deleteUser(User user) {
        if (user == null || user.getUserId() == null)
            return new UserExecution(UserStateEnum.NULL_USER);
        try {
            if (!userDao.existsById(user.getUserId()))
                return new UserExecution(UserStateEnum.DELETE_ERROR);
            userDao.delete(user);
            return new UserExecution(UserStateEnum.SUCCESS, user);
        } catch (Exception e) {
            throw new UserException("删除User失败" + e.getMessage());
        }
    }

    @Override
    public UserExecution deleteUsers(List<User> userList) {
        if (userList == null) {
            return new UserExecution(UserStateEnum.NULL_USER);
        }
        try {
            userDao.deleteAll(userList);
            return new UserExecution(UserStateEnum.SUCCESS, userList);
        } catch (Exception e) {
            throw new UserException("批量删除出错");
        }
    }

    @Override
    public UserExecution modifyPasswordByUserId(Long userId, String oldPassword, String newPassword) {
        if (userId == null || oldPassword == null || newPassword == null) {
            return new UserExecution(UserStateEnum.NULL_USER);
        }
        try {
            if (userDao.existsById(userId)) {
                if (oldPassword.equals(userDao.queryUserByUserId(userId).getPassword())) {
                    int result = userDao.modifyPasswordByUserId(userId, oldPassword, newPassword);
                    if (result == 1) {
                        User user = userDao.queryUserByUserId(userId);
                        user.setUpdateTime(new Date());
                        userDao.save(user);
                        return new UserExecution(UserStateEnum.SUCCESS, user);
                    } else {
                        return new UserExecution(UserStateEnum.UPDATE_ERROR);
                    }
                } else {
                    return new UserExecution(UserStateEnum.UPDATE_ERROR);
                }
            } else {
                return new UserExecution(UserStateEnum.UPDATE_ERROR);
            }
        } catch (Exception e) {
            throw new UserException("修改密码出错" + e.getMessage());
        }
    }

    @Override
    public UserExecution modifyInformation(User newUser) {
        if (newUser == null || newUser.getUserId() == null) {
            return new UserExecution(UserStateEnum.NULL_USER);
        }
        try {
            if (!userDao.existsById(newUser.getUserId())) {
                return new UserExecution(UserStateEnum.UPDATE_ERROR);
            }
            User user = userDao.queryUserByUserId(newUser.getUserId());
            if (newUser.getName() != null) user.setName(newUser.getName());
            if (newUser.getGender() != null) user.setGender(newUser.getGender());
            if (newUser.getPhoneNum() != null) user.setPhoneNum(newUser.getPhoneNum());
            user.setUpdateTime(new Date());
            if (newUser.getHeadImg() != null) user.setHeadImg(newUser.getHeadImg());
            return new UserExecution(UserStateEnum.SUCCESS, user);
        } catch (Exception e) {
            throw new UserException("修改信息出错" + e.getMessage());
        }
    }

    @Override
    public UserExecution queryUserById(Long userId) {
        if (userId == null) {
            return new UserExecution(UserStateEnum.NULL_USER);
        }
        try {
            if(!userDao.existsById(userId))
                return new UserExecution(UserStateEnum.NULL_USER);
            User user = userDao.queryUserByUserId(userId);
            return new UserExecution(UserStateEnum.SUCCESS, user);
        } catch (Exception e) {
            throw new UserException("查询出错" + e.getMessage());
        }
    }

    @Override
    public UserExecution queryUserByName(String name) {
        if (name == null) {
            return new UserExecution(UserStateEnum.NULL_USER);
        }
        try {
            List<User> userList = userDao.queryUsersByName(name);
            return new UserExecution(UserStateEnum.SUCCESS, userList);
        } catch (Exception e) {
            throw new UserException("批量查询出错" + e.getMessage());
        }
    }
}
