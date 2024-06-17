package com.Web.GreatMing.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Web.GreatMing.Response;

@RestController
public class FileUploadController {
    
    @PostMapping("/upload")
    public Response<?> upload(MultipartFile file) throws IOException{
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.equals("")){
            return Response.newFail("上传失败,文件为空.");
        }
        // 使用UUID保证文件名字唯一，防止文件覆盖
        String filename = UUID.randomUUID().toString().replace("-", "") + originalFilename.substring(originalFilename.lastIndexOf("."));
        file.transferTo(new File("/home/HanXiao/Code/Java/GreatMing/files/" + filename));
        return Response.newSuccess("url访问地址...","返回访问地址成功！");
    }

}
