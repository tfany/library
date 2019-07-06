package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.service.RankService;
import com.huihuitf.library.util.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping("/list")
    public CommonResult list(int pageNum,int pageSize){
        Map<String,Object> map=new HashMap<>();
        PageHelp.pageDeal(pageNum,pageSize,rankService.findAllRank().size(),map);
        map.put("list",rankService.findAllRank(pageNum-1,pageSize));
        return CommonResult.success(map);
    }
}
