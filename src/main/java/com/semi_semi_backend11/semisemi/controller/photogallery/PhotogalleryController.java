package com.semi_semi_backend11.semisemi.controller.photogallery;

import com.semi_semi_backend11.semisemi.dto.PhotoGalleryDto;
import com.semi_semi_backend11.semisemi.service.photogallery.PhotogalleryService;
import com.semi_semi_backend11.semisemi.util.GalleryResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PostMapping("/photogallery/upload")
    public ResponseEntity<?> uploadGallery(
            @RequestParam("writer") String writer,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("photoUrl") String photoUrl,
            @RequestParam("photo") MultipartFile photo
    ) {

//        System.out.println(writer);
//        System.out.println(title);
//        System.out.println(content);
//        System.out.println(photoUrl);
//        System.out.println(photo);

        // DTO생성
        PhotoGalleryDto dto = new PhotoGalleryDto();
        dto.setWriter(writer);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setPhotoUrl(photoUrl);
        dto.setPhoto(photo);

        // 실행
        GalleryResultEnum result = service.uploadGallery(photo, dto);

        // 결과 검증
        if (result == GalleryResultEnum.Success)
            return ResponseEntity.ok("이미지 업로드 성공");
        else if (result == GalleryResultEnum.FileIsEmpty)
            return ResponseEntity.badRequest().body("올바른 이미지를 선택해주세요.");
        else if (result == GalleryResultEnum.FileTooLarge)
            return ResponseEntity.badRequest().body("파일의 크기가 너무 큽니다.");
        else
            return ResponseEntity.badRequest().body("이미지 업로드 실패");
    }
}




