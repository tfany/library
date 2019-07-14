package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.dto.HistoryDto;
import com.huihuitf.library.entity.History;
import com.huihuitf.library.service.HistoryService;
import com.huihuitf.library.util.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("order")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @PostMapping("add")
    public CommonResult add(@RequestBody HistoryDto historyDto){
        History history= historyService.add(historyDto);
        if(history==null){
            return CommonResult.failed("0本咋租???");
        }
        return CommonResult.success(history);
    }

    @GetMapping("list")
    public CommonResult list(int pageNum,int pageSize){
        Map<String, Object> list=new HashMap<>();
        PageHelp.pageDeal(pageNum, pageSize, historyService.queryTotal(),list);
        list.put("list", historyService.findAllBook(pageNum - 1, pageSize));
        return CommonResult.success(list);
    }

    @GetMapping("get")
    public CommonResult get(Long id){
        return CommonResult.success(historyService.findBookByUserId(id));
    }

    @PostMapping("huan")
    public CommonResult huan(String id){
        return CommonResult.success(historyService.huan(id));
    }
}
