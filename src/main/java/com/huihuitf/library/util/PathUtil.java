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
        String basePath;
        String os=System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            basePath="d:/library/images/";
        }else{
            basePath="/home/tfany/library/images/";
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
     * 只保留数据库存在的图片
     * @param url url
     */
    public static void deleteFiles(String url){
        if(url!=null) {
            File file = new File(PathUtil.getImgBasePath() + url.substring(1));
            if (file.exists()) {
                File[] files = file.getParentFile().listFiles();
                for (File file1 : files) {
                    if (!file.getName().equals(file1.getName())) {
                        file1.delete();
                    }
                }
            }
        }
    }

    public static void deleteDir(String url){
        File file=new File(PathUtil.getImgBasePath()+url.substring(1));
        if(file.exists()){
            file.delete();
        }
    }

    /**
     * 获取存放图片的地址
     *
     * @param userId 用户id
     * @return  imagePath 相随地址
     */
    public static String getUserImagePath(long userId){
        return "/user/headImg/" + userId + "/";
    }

    public static String getBookFaceImagePath(String bookId){
        return "/book/faceBook/" + bookId + "/";

    }

    public static String getCategoryPath(int categoryId){
        return "/category/" + categoryId + "/";

    }
}
