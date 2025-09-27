package com.semi_semi_backend11.semisemi.service.photogallery;

import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;
import com.semi_semi_backend11.semisemi.dto.PhotoGalleryDto;
import com.semi_semi_backend11.semisemi.entity.PhotoGallery;
import com.semi_semi_backend11.semisemi.repository.PhotoGalleryRepository;
import com.semi_semi_backend11.semisemi.util.GalleryResultEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotogalleryServiceImpl implements PhotogalleryService {
    private final PhotoGalleryRepository repository;

    public PhotoGalleryDto toDto(PhotoGallery photogallery){
        return PhotoGalleryDto.builder()
                .galleryId(photogallery.getGalleryId())
                .writer(photogallery.getWriter())
                .title(photogallery.getTitle())
                .content(photogallery.getContent())
                .photoUrl(photogallery.getPhotoUrl())
                .createdAt(photogallery.getCreatedAt())
                .build();
    }
    public PhotoGallery toEntity(PhotoGalleryDto dto){
        return PhotoGallery.builder()
                .galleryId(dto.getGalleryId())
                .writer(dto.getWriter())
                .title(dto.getTitle())
                .content(dto.getContent())
                .photoUrl(dto.getPhotoUrl())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    @Override
    public List<PhotoGalleryDto> findAllGallery() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<PhotoGalleryDto> findGallery(Integer galleryId) {
        return repository.findById(galleryId).map(this::toDto);
    }

    @Override
    public GalleryResultEnum uploadGallery(MultipartFile file, PhotoGalleryDto gallery) {
        // 1. 파일이 비어있는지 확인
        String uploadDir = "images/gallery/";
        if (file.isEmpty()) {
            return GalleryResultEnum.FileIsEmpty;
        }

        // 1_2. 파일의 크기 확인
        if(file.getSize() > 5 * 1024 * 1024) {
            return GalleryResultEnum.FileTooLarge;
        }

        try {
            // 2. 고유한 파일명 세팅을 위한 세팅
            String filename = file.getOriginalFilename(); // 파일명
            String originalFilename = filename;  // 원본 파일명 보존

            // 파일명 중복 확인 및 고유한 파일명 생성
            int counter = 1;
            while (Files.exists(Paths.get(uploadDir + filename))) {
                // 파일명이 이미 존재하면 (1), (2)와 같은 형식으로 수정
                filename = originalFilename.replaceFirst("([^.]+)(\\.[^.]+)?$", "$1(" + counter + ")$2");
                counter++;  // 숫자 증가
            }

            // 3. 파일 저장
            Path filePath = Paths.get(uploadDir + filename);
            Files.createDirectories(filePath.getParent()); // 폴더가 없으면 생성
            Files.write(filePath, file.getBytes());

            // 4. 성공 시 DB에 저장할 url 생성
            String imgUrl = uploadDir + "/" + filename;
            gallery.setPhotoUrl(imgUrl);
            repository.save(toEntity(gallery));
            return GalleryResultEnum.Success;

        } catch(Exception e) {
            e.printStackTrace();
            return GalleryResultEnum.Failure;
        }
    }


}
