package com.semi_semi_backend11.semisemi.service.photogallery;

import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;
import com.semi_semi_backend11.semisemi.dto.PhotoGalleryDto;
import com.semi_semi_backend11.semisemi.util.GalleryResultEnum;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PhotogalleryService {
    List<PhotoGalleryDto> findAllGallery();
    Optional<PhotoGalleryDto> findGallery(Integer galleryId);
    GalleryResultEnum uploadGallery(MultipartFile file, PhotoGalleryDto gallery);
}
