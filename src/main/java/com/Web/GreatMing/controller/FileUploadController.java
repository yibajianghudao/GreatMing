package com.Web.GreatMing.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.service.FileUploadServiceimpl;
import com.Web.GreatMing.service.UserService;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


import io.minio.errors.MinioException;

@RestController
public class FileUploadController {

    
    
    @Autowired
    FileUploadServiceimpl fileUploadService;

    @Autowired
    UserService userService;

    @PostMapping("/upload")
    public Response<?> upload(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.equals("")){
            return Response.newFail("上传失败,文件为空.");
        }
        // 使用UUID保证文件名字唯一，防止文件覆盖
        String filename = UUID.randomUUID().toString().replace("-", "") + originalFilename.substring(originalFilename.lastIndexOf("."));
        // file.transferTo(new File("/home/HanXiao/Code/Java/GreatMing/files/" + filename));
        try {
            String result = fileUploadService.fileUpload(filename, file);
            userService.updateAvatar(result);
            return Response.newSuccess(result, "返回访问地址成功！");
        } catch (MinioException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            return Response.newFail(e.getMessage());
        }
        
    }

}
