package io.vmbears.xml.controllers;

import io.vmbears.xml.services.UploadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/upload")
@AllArgsConstructor
public class UploadController {

    private final UploadService service;

    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            final Optional<String> extension = this.service.extension(file.getOriginalFilename());
            if (extension.isEmpty() || !"xml".equalsIgnoreCase(extension.get())) {
                System.out.println("Arquivo inválido!");
                return ResponseEntity.noContent().build();
            }
            this.service.upload(file.getInputStream());
        } catch (IOException exp) {
            System.err.println(exp.getMessage());
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
