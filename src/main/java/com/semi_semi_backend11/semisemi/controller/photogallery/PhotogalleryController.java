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

    // 레거시 갤러리 코드
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
//        // 1. 파일이 비어있는지 확인
//        String uploadDir = "images/gallery/";
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("업로드할 파일을 선택해주세요.");
//        }
//
//        try {
//            // 2. 고유한 파일명 생성
//            String originalFilename = file.getOriginalFilename();
//            String extension = "";
//            if (originalFilename != null && originalFilename.contains(".")) {
//                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//            }
//            String uniqueFilename = UUID.randomUUID().toString() + extension;
//
//            // 3. 파일 저장
//            Path filePath = Paths.get(uploadDir + uniqueFilename);
//            Files.createDirectories(filePath.getParent()); // 폴더가 없으면 생성
//            Files.write(filePath, file.getBytes());
//
//            // 4. 성공 시 웹에서 접근 가능한 URL 반환
//            log.info("파일이 성공적으로 저장되었습니다: {}", uniqueFilename);
//            return ResponseEntity.ok("/images/" + uniqueFilename);
//
//        } catch (IOException e) {
//            log.error("파일 업로드 실패", e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드에 실패했습니다.");
//        }
//    }

    @PostMapping("/photogallery/upload")
    public ResponseEntity<String> uploadImage(@ModelAttribute("file") MultipartFile file, @ModelAttribute("gallery") PhotoGalleryDto gallery) {
        GalleryResultEnum result = service.uploadGallery(file,gallery);

        if(result == GalleryResultEnum.Success)
            return ResponseEntity.ok("이미지 업로드 성공");
        else if(result == GalleryResultEnum.FileIsEmpty)
            return ResponseEntity.badRequest().body("올바른 이미지를 선택해주세요.");
        else if(result == GalleryResultEnum.FileTooLarge)
            return ResponseEntity.badRequest().body("파일의 크기가 너무 큽니다.");
        else
            return ResponseEntity.badRequest().body("이미지 업로드 실패");
    }

}
