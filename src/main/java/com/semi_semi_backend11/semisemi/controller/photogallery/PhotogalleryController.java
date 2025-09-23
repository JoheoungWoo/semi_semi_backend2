package com.semi_semi_backend11.semisemi.controller.photogallery;

import com.semi_semi_backend11.semisemi.dto.PhotoGalleryDto;
import com.semi_semi_backend11.semisemi.service.photogallery.PhotogalleryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(
        origins = "http://localhost:3000",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH,RequestMethod.OPTIONS},
        allowedHeaders = "*")
public class PhotogalleryController {
    @Autowired
    private PhotogalleryService service;

    @GetMapping("/photogallery/list")
    public ResponseEntity<List<PhotoGalleryDto>> getPhotogalleryInfoAll(){
        List<PhotoGalleryDto> dto= service.findAllGallery();
        if(dto.size() > 0){
            return ResponseEntity.ok(dto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/photogallery/info/{id}")
    public ResponseEntity<PhotoGalleryDto> getPhotogalleryInfo(@PathVariable("id") Integer id){
        Optional<PhotoGalleryDto> dto= service.findGallery(id);
        if(dto.isPresent()){
            return ResponseEntity.ok(dto.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}
