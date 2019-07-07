package com.huihuitf.library.service;

import com.huihuitf.library.entity.Manager;
import org.springframework.web.multipart.MultipartFile;

public interface ManagerService {
    boolean passwordIsTrue(Long userId,String password);

    Manager queryById(Long id);

    int update(Manager manager);

    String addFace(Long id,MultipartFile file);
}
