package com.huihuitf.library.util;

import java.io.File;

public class PathUtil {
    /**
     *获取存放图片的绝对路径
     *
     * @return path
     * windows和linux位置不同
     */
    public static String getImgBasePath(){
        String basePath="";
        String os=System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            basePath="d:/library/images/";
        }else{
            basePath="/home/library/images/";
        }
        return basePath;
    }

    public static void deleteFile(String storePath){
        File fileOrPath=new File(PathUtil.getImgBasePath()+storePath.substring(1));
        if(fileOrPath.exists()){
            if(fileOrPath.isDirectory()){
                File files[]=fileOrPath.listFiles();
                for (File file : files) {
                    file.delete();
                }
            }
            fileOrPath.delete();
        }
    }

    /**
     * 获取存放图片的地址
     *
     * @param userId 用户id
     * @return  imagePath 相随地址
     */
    public static String getUserImagePath(long userId){
        return "/userHeadImg/" + userId + "/";
    }
}
