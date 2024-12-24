package com.ra.sesson02.controller;

import com.ra.sesson02.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/upload")
@RequiredArgsConstructor
public class UploadFileController {
    private final UploadService uploadService;
    @PostMapping
    public ResponseEntity<String> upload(@RequestParam MultipartFile file){
        String fileName = uploadService.uploadImage(file);
        return new ResponseEntity<>(fileName, HttpStatus.CREATED);
    }
}
