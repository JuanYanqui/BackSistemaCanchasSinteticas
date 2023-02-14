package com.sistema.canchas.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@CrossOrigin
@RequestMapping(path = "/image")
public class ImagenController {

    //@Autowired
    //private ImageService service;

   /*- @PostMapping(value="/upload-image")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file,@RequestParam String folder) {
        return new ResponseEntity<String>(service.uploadFile(file, folder), HttpStatus.CREATED);
    }*/

    // NEWS
    private static String UPLOAD_DIR = "uploads";

    @PostMapping("/subir")
    public void uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        byte[] bytes = image.getBytes();
        Path path = Paths.get(UPLOAD_DIR + "/" + image.getOriginalFilename());
        Files.write(path, bytes);
    }
    @GetMapping("/images/{imageName}")
    public byte[] getImagen(@PathVariable String imageName) throws IOException {
        Path path = Paths.get(UPLOAD_DIR + "/" + imageName);
        return Files.readAllBytes(path);
    }
// NEWS
}

