package com.example.ghilibi.controller;

import com.example.ghilibi.dto.TextGeneration;
import com.example.ghilibi.service.ghilibiartservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:5173","http://127.0.0.1.5173"})
@RequiredArgsConstructor
public class generationController {

    private final ghilibiartservice ghilibiartservice;
    @PostMapping(value="/generate" ,produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateGhilibiart(@RequestParam("image")MultipartFile image,
                                                     @RequestParam("prompt")String prompt){
        try{
            byte[] imagesBytes = ghilibiartservice.createghibliart(image,prompt);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imagesBytes);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping(value="/generate-from-text",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateGhilibiartfromtext(@RequestBody TextGeneration request){
        try{
            byte[] imageBytes = ghilibiartservice.createghibliart(request.getPrompt(), request.getStyle());
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
