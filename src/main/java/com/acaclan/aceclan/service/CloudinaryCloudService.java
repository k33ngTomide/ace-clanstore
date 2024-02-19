package com.acaclan.aceclan.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class CloudinaryCloudService implements CloudinaryService{

    private final Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile file) {
        try {
            Uploader uploader = cloudinary.uploader();
            Map<?,?> response = uploader.upload(file.getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            return (String)response.get("secure_url");
        } catch (IOException exception){
            return exception.getMessage();
        }

    }
}
