package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.ManagerDao;
import com.huihuitf.library.entity.Manager;
import com.huihuitf.library.service.ManagerService;
import com.huihuitf.library.util.ImageUtil;
import com.huihuitf.library.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public boolean passwordIsTrue(Long userId, String password) {
        if (managerDao.existsById(userId)) {
            return managerDao.getOne(userId).getPassword().equals(password);
        }
        return false;
    }

    @Override
    public Manager queryById(Long id) {
        return managerDao.findById(id).orElse(new Manager());
    }

    @Override
    public int update(Manager manager) {
        try {
            managerDao.save(manager);
            PathUtil.deleteFiles(manager.getHeadImg());
            return 1;
        }catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String addFace(Long id,MultipartFile file) {

        if(file!=null) {
            //先把图片存起来
            String dest = PathUtil.getManagerFaceImagePath(id);
            //返回存放路径
            return ImageUtil.generateThumbnail(file, dest);
        }
        return null;
    }
}
