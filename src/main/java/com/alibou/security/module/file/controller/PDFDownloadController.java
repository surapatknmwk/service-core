package com.alibou.security.module.file.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibou.security.util.FileUtil;

import org.springframework.core.io.Resource;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/api/v1/file")
public class PDFDownloadController {
    
    @GetMapping("/downloadFile/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename) {
        FileUtil downloadUtil = new FileUtil();
        Resource resource = null;

        try {
            resource = downloadUtil.getFileAsResource(filename);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
         
        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
         
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
         
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);       
    }
}
