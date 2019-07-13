package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.UserDao;
import com.huihuitf.library.entity.User;
import com.huihuitf.library.service.UserService;
import com.huihuitf.library.util.ImageUtil;
import com.huihuitf.library.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 增加用户
     *
     * @param user
     * @param headImg
     * @return
     */
    @Override
    public User addUser(User user, MultipartFile headImg) {

        try {
            if (userDao.findByPhoneNum(user.getPhoneNum()) != null) {
                return null;
            }
            //设置用户初始值
            user.setUserId(queryMaxUserId() + 1L);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());

            //设置用户头像 并存盘
            if (headImg != null)
                addUserImg(user, headImg);


            return userDao.save(user);
        }catch (Exception e){
            return null;
        }


    }

    /**
     * 设置头像
     *
     * @param user
     * @param headImg
     */
    private void addUserImg(User user, MultipartFile headImg) {
        String dest = PathUtil.getUserImagePath(user.getUserId());
        String shopImgAddr = ImageUtil.generateThumbnail(headImg, dest);
        user.setHeadImg(shopImgAddr);
    }

    /**
     * 删除用户
     *
     * @param user
     */
    @Override
    public void deleteUser(Long user) {
        String img= userDao.findById(user).orElse(new User()).getHeadImg();
        if(img!=null&& !img.equals("")){
            PathUtil.deleteFiles(img);
        }
        userDao.deleteById(user);
    }

    @Override
    public String addFace(Long userId, MultipartFile face) {

        if(face!=null) {
            //先把图片存起来
            String dest = PathUtil.getUserImagePath(userId);
            //返回存放路径
            return ImageUtil.generateThumbnail(face, dest);
        }
        return null;
    }

    /**
     * 批量删除用户
     *
     * @param userList
     */
    @Override
    public void deleteUsers(List<User> userList) {

        userDao.deleteAll(userList);

    }

    /**
     * 修改密码
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return 失败返回0 成功返回1
     */
    @Override
    public int modifyPasswordByUserId(Long userId, String oldPassword, String newPassword) {
        User user = userDao.getOne(userId);
        if (user == null) {
            return 0;
        }
        if (user.getPassword().equals(oldPassword)) user.setPassword(newPassword);
        return 1;
    }

    /**
     * 修改user信息
     * @param user
     * @return
     */
    @Override
    public int modifyInformation(User user) {
        if (userDao.existsById(user.getUserId())) {
            userDao.save(user);
            return 1;
        }
        return 0;
    }

    /**
     * 判断用户名是否存在 密码是否正确
     * @param userId
     * @param password
     * @return
     */
    @Override
    public boolean passwordIsTrue(Long userId, String password) {
        if(userDao.existsById(userId)) {
            if( userDao.getOne(userId).getPassword().equals(password)){
                userDao.findById(userId).orElse(new User()).setUpdateTime(new Date());
                return true;
            }
            return false;
        }else{
            if( userDao.findByPhoneNum(String.valueOf(userId)) != null
                    && userDao.findByPhoneNum(String.valueOf(userId)).getPassword().equals(password)){
                userDao.findByPhoneNum(String.valueOf(userId)).setUpdateTime(new Date());
                return true;
            }
            return false;
        }
    }

    /**
     * 查询用户 可以通过id name phone
     * @param user
     * @return
     */
    @Override
    public List<User> queryUser(User user) {
        return userDao.queryUserByUserIdOrNameOrPhoneNum(user.getUserId(),user.getName(),user.getPhoneNum());
    }

    @Override
    public User queryByPhoneNum(String num) {
        return userDao.findByPhoneNum(num);
    }

    /**
     * 主键规则
     * @return
     */
    @Override
    public Long queryMaxUserId() {
        return userDao.queryMaxUser()==null?10000L:userDao.queryMaxUser();
    }

    @Override
    public List<User> listUser(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"userId");
        Pageable pageable= PageRequest.of(pageNum,pageSize, sort);
        Page<User> bookPage = userDao.findAll(pageable);
        return bookPage.getContent();
    }

    @Override
    public int queryTotal() {
        return userDao.findAll().size();
    }
}
