package com.huihuitf.library.dao;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class UserDaoTest {

    @Test
    public void queryUserByUserIdOrNameOrPhoneNum() {
    }

    @Test
    public void findByPhoneNum() {
    }

    @Test
    public void queryMaxUser() {
    }

    @Test
    public void modifyPasswordByUserId() {
    }

    @Test
    public void createFile(){
        File test= new File("/home/library/test.txt");
        try {
            Assert.assertTrue(test.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}