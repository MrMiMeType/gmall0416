package com.atguigu.gmall0416.manage.controller;


import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {
    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file")MultipartFile file) throws IOException, MyException {
        //保存到文件服务器
        String fileName = this.getClass().getResource("/tracker.conf").getFile();
        ClientGlobal.init(fileName);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String extName = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
        String[] upload_file = storageClient.upload_file(file.getBytes(), extName, null);
        String filePath="";
        if(upload_file.length>=2){
            filePath="http://file.gmall.com/"+upload_file[0]+"/"+upload_file[1];
        }
        //返回图片地址
        return filePath;
    }
    @Test
    public void testUpload() throws Exception {
        String file = this.getClass().getResource("/tracker.conf").getFile();
        ClientGlobal.init(file);
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer=trackerClient.getConnection();
        StorageClient storageClient=new StorageClient(trackerServer,null);
        String orginalFilename="C:\\Users\\31014\\Desktop\\1.jpg";
        String[] upload_file = storageClient.upload_file(orginalFilename, "jpg", null);
        for (int i = 0; i < upload_file.length; i++) {
            String s = upload_file[i];
            System.out.println("path = " + s);
        }
    }


}
