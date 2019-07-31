package com.qf.controller;

  /*
    @author: LMFeng
    @date: 2019-07-31 14:29
    @desc:
  */

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.qf.server.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/res")
public class ResController {

    @Autowired
    private FastFileStorageClient fileStorageClient;

    @Autowired
    private IUserServer userServer;

    @RequestMapping("/uploaderHeader")
    public Map<String,String>uploaderHeader(MultipartFile file,Integer uid){
        Map<String,String>map =new HashMap<>();

        String filename= UUID.randomUUID().toString();

        try {
            StorePath storePath=fileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(),file.getSize(),"PNG",null);

            //获得上传lujing
            String uploadPath=storePath.getFullPath();
            String uploadCrmPath=uploadPath.replace(".","_80x80.");
            map.put("header",uploadPath);
            map.put("headerCrm",uploadCrmPath);

            userServer.updateHeader(uploadPath,uploadCrmPath,uid);
        } catch (IOException e) {
            e.printStackTrace();
        }
return map;
    }



}
