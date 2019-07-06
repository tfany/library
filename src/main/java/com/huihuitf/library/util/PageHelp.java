package com.huihuitf.library.util;

import java.util.Map;

public class PageHelp {
    public static int getTotalPage(int total,int pageSize){
        int totalPage = total / pageSize;
        if (total % pageSize != 0) {
            totalPage++;
        }
        return totalPage;
    }

    public static void pageDeal(int pageNum, int pageSize, int total, Map<String, Object> map) {

        int totalPage = getTotalPage(total, pageSize);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("total", total);
        map.put("totalPage", totalPage);
    }
}
