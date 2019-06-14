package com.huihuitf.library.service.impl;

import com.huihuitf.library.entity.User;
import com.huihuitf.library.service.UserService;
import com.huihuitf.library.util.FileToMult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser() throws IOException {
        User user =new User();
        user.setName("江泽晖");
        user.setGender("男");
        user.setPassword("123456");
        user.setPassword("736549664@qq.com");
        user.setUserId(123456L);
        user.setPhoneNum("13992543350");
        MultipartFile file= FileToMult.getCommonsMult("C:\\Users\\huige\\Pictures\\girl1.png");
        User user1 = userService.addUser(user,file);
       // System.out.println(userExecution);

    }



    @Test
    public void deleteUser() {
        User user = new User();
        //html.setUserId(111111111L);
        user.setName("江泽晖");
        userService.deleteUser(user);
    }

    @Test
    public void deleteUsers() {
        User user = new User();
        user.setUserId(10001L);
    }

    @Test
    public void modifyPasswordByUserId() {
        int userExecution=userService.modifyPasswordByUserId(111111111L,"736549664@qq.com","132456");
        System.out.println(userExecution);
    }

    @Test
    public void modifyInformation() {
        User user =new User();
        user.setName("江泽晖");
        user.setGender("女");
        user.setUserId(111111111L);
        user.setPhoneNum("13992543350");
        int userExecution=userService.modifyInformation(user);
        System.out.println(userExecution);
    }

}