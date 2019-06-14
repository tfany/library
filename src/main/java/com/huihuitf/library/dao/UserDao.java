package com.huihuitf.library.dao;

import com.huihuitf.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    List<User> queryUserByUserIdOrNameOrPhoneNum(Long userId, String name, String phoneNum);

    @Query("SELECT MAX(userId) from User ")
    Long queryMaxUser();

    @Modifying
    @Query("update User set password=:newPassword where userId=:userId and password=:oldPassword")
    int modifyPasswordByUserId(@Param("userId")Long userId, @Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword);


}
