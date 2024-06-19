package com.Web.GreatMing.service;

import java.io.IOException;
import java.io.InputStream;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;

@Service
public class FileUploadServiceimpl implements FileUploadService {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.endpoint}")
    private String minioEndpoint;

    @Value("${minio.bucket-name}")
    private String minioBucketName;

    public String fileUpload(String filename, MultipartFile file) throws MinioException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        InputStream inputStream = file.getInputStream();
        minioClient.putObject(
            PutObjectArgs.builder()
                .bucket(minioBucketName)
                .object(filename)
                .stream(inputStream, inputStream.available(), -1)
                .contentType(file.getContentType())
                .build()   
        );
        return minioEndpoint+'/'+minioBucketName+'/'+filename;
    }
    
}
