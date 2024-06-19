package com.Web.GreatMing.service;

import java.io.IOException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.multipart.MultipartFile;

import io.minio.errors.MinioException;

public interface FileUploadService {
    public String fileUpload(String filename, MultipartFile file) throws MinioException, IOException, NoSuchAlgorithmException, InvalidKeyException;
}
