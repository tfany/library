package com.huihuitf.library.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public class FileToMult {
    public static CommonsMultipartFile getCommonsMult(String name) throws IOException {
        File file = new File(name);
        FileItem fileItem = new DiskFileItem(
                "formFieldName",//form表单文件控件的名字随便起
                Files.probeContentType(file.toPath()),//文件类型
                false, //是否是表单字段
                file.getName(),//原始文件名
                (int) file.length(),//Interger的最大值可以存储两部1G的电影
                file.getParentFile());//文件会在哪个目录创建

        //最关键的一步：为DiskFileItem的OutputStream赋值
        //IOUtils是org.apache.commons.io.IOUtils;
        //与此类似的还有FileUtils
        IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());

        return new CommonsMultipartFile(fileItem);
    }
}
