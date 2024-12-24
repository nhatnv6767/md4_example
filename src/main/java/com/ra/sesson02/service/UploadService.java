package com.ra.sesson02.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UploadService {
    private final Cloudinary cloudinary;

    public String uploadImage(MultipartFile file){
        // lay ten file goc
        String originalFilename = file.getOriginalFilename();

        if(originalFilename != null && originalFilename.contains(".")){
            originalFilename = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        }

        // them ten file vao tham so upload
        Map uploadParams = ObjectUtils.asMap(
                "public_id", "ra/" + originalFilename,
                "overwrite", true
        );

        try {
            // upload file len cloudinary
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), uploadParams);
            return uploadResult.get("url").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
