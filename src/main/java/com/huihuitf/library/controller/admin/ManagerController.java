package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.entity.Manager;
import com.huihuitf.library.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ManagerService managerService;

    @PostMapping("/verifylogin")
    //@ResponseBody
    public CommonResult userLogin(@RequestBody Manager user) {
        Map<String, Object> tokenMap = new HashMap<>();
        if (managerService.passwordIsTrue(user.getManagerId(), user.getPassword())) {
            tokenMap.put("token", user.getManagerId());
            return CommonResult.success(tokenMap);
        }
        return CommonResult.failed("密码错误");
    }

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping("/userinfo")
    public CommonResult userInfo() {
        String token = request.getHeader("token");
        Map<String, Object> data = new HashMap<>();

        if(token!=null && !token.equals("") &&managerService.queryById(Long.valueOf(token)).getManagerId()!=null) {
            Manager manager = managerService.queryById(Long.valueOf(token));
            data.put("username", manager.getManagerName());
            data.put("id", manager.getManagerId());
            data.put("roles", new String[]{"Manager"});
            data.put("icon", manager.getHeadImg());
            data.put("password", manager.getPassword());
            return CommonResult.success(data);
        }
        return CommonResult.success("");
    }

    @PostMapping("/updateImg")
    public CommonResult update( @RequestBody Manager manager1) {
        String token = request.getHeader("token");
        String img=manager1.getHeadImg();
        Manager manager=managerService.queryById(Long.valueOf(token));
        if(manager.getManagerId()!=null) {
            manager.setHeadImg(img);
            managerService.update(manager);
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @PostMapping("/upload/{id}")
    public CommonResult upload(@PathVariable Long id, MultipartFile file) {

        try {
            String imgUrl = managerService.addFace(id, file);
            if (imgUrl!=null)
                return CommonResult.success(imgUrl);
            return CommonResult.failed();

        } catch (Exception e) {
            return CommonResult.failed();
        }
    }

    /**
     * 退出登录
     * @return success
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }
}
