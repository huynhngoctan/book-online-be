package com.nlu.bookonlinebe.controllers;

import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/FileUpload")
public class FileUploadController {
    @Autowired
    StorageService storageService;

    @PostMapping
    public ResponseEntity<ResponseObject> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String generatedFileName = storageService.storageFile(file);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Upload file successfully", generatedFileName)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(
                            "ok",
                            e.getMessage(),
                            ""
                    )
            );
        }
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<byte[]> readDetailFile(@PathVariable String filename){
        try{
            byte[] bytes = storageService.readFileContent(filename);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(bytes);
        } catch (Exception e){
            return ResponseEntity
                    .noContent().build();
        }

    }
}
