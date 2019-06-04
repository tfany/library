package com.huihuitf.library.service.impl;

import com.huihuitf.library.dto.UserExecution;
import com.huihuitf.library.entity.User;
import com.huihuitf.library.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user =new User();
        user.setName("江泽晖");
        user.setGender("男");
        user.setPassword("123456");
        user.setPassword("736549664@qq.com");
        user.setUserId(111111111L);
        user.setPhoneNum("13992543350");
        UserExecution userExecution = userService.addUser(user);
        System.out.println(userExecution);

    }

    @Test
    public void addUsers() {
        User user =new User();
        user.setName("江泽晖");
        user.setGender("男");
        user.setPassword("123456");
        user.setPassword("736549664@qq.com");
        user.setUserId(111111111L);
        user.setPhoneNum("13992543350");

        User user2 =new User();
        user2.setName("江泽晖");
        user2.setGender("男");
        user2.setPassword("123456");
        user2.setUserId(222222222L);
        user2.setPhoneNum("13992543350");
        List<User>  userList=new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        UserExecution userExecution=userService.addUsers(userList);
        System.out.println(userExecution.getUserList());

    }

    @Test
    public void deleteUser() {
        User user = new User();
        //html.setUserId(111111111L);
        user.setName("江泽晖");
        UserExecution userExecution=userService.deleteUser(user);
        System.out.println(userExecution);
    }

    @Test
    public void deleteUsers() {
        User user = new User();
        user.setUserId(222222222L);
        List<User> userList=new ArrayList<>();
        userList.add(user);
        UserExecution userExecution=userService.deleteUsers(userList);
        System.out.println(userExecution);
    }

    @Test
    public void modifyPasswordByUserId() {
        UserExecution userExecution=userService.modifyPasswordByUserId(111111111L,"736549664@qq.com","132456");
        System.out.println(userExecution);
    }

    @Test
    public void modifyInformation() {
        User user =new User();
        user.setName("江泽晖");
        user.setGender("女");
        user.setUserId(111111111L);
        user.setPhoneNum("13992543350");
        UserExecution userExecution=userService.modifyInformation(user);
        System.out.println(userExecution);
    }

    @Test
    public void queryUserById() {
        UserExecution userExecution=userService.queryUserById(111L);
        System.out.println(userExecution.getUser());
    }

    @Test
    public void queryUserByName() {
        UserExecution userExecution=userService.queryUserByName("江泽晖");
        System.out.println(userExecution.getUserList());
    }
}