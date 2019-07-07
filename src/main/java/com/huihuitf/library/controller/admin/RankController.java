package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.entity.Rank;
import com.huihuitf.library.service.RankService;
import com.huihuitf.library.util.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping("/list")
    public CommonResult list(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageHelp.pageDeal(pageNum, pageSize, rankService.findAllRank().size(), map);
        map.put("list", rankService.findAllRank(pageNum - 1, pageSize));
        return CommonResult.success(map);
    }

    @GetMapping(value = "/{id}")

    public CommonResult get(@PathVariable Integer id) {
        Rank rank;
        rank = rankService.findRankByLevel(id);
        return CommonResult.success(rank);

    }

    @PostMapping(value = "/update/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Rank rank) {

        int count = rankService.modifyRank(rank);
        if (count > 0)
            return CommonResult.success(rank);
        else return CommonResult.failed("修改失败");

    }

    @PostMapping(value = "/create")
    public CommonResult create( @RequestBody Rank rank) {

        Rank rank1 = rankService.addLevel(rank);
        if (rank1 !=null)
            return CommonResult.success(rank);
        else return CommonResult.failed("等级已存在,请修改");

    }

    @GetMapping(value = "/delete/{id}")
    public CommonResult delete( @PathVariable Integer id) {

        int count = rankService.deleteByLevel(id);
        if (count > 0)
            return CommonResult.success(null);
        else return CommonResult.failed("删除失败");

    }
}
