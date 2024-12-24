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

    public String uploadImage(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return null;
        }

        // lay ten file goc
        String originalFilename = file.getOriginalFilename();
        String fileName = "";

        if (originalFilename != null && originalFilename.contains(".")) {
            fileName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        }

        String uniqueFileName = fileName + "_" + System.currentTimeMillis();

        // them ten file vao tham so upload
        Map uploadParams = ObjectUtils.asMap(
                "public_id", "ra/" + uniqueFileName,
                "overwrite", true);

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
