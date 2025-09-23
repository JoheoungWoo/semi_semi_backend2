package com.semi_semi_backend11.semisemi.service.photogallery;

import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;
import com.semi_semi_backend11.semisemi.dto.PhotoGalleryDto;
import com.semi_semi_backend11.semisemi.entity.PhotoGallery;
import com.semi_semi_backend11.semisemi.repository.PhotoGalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
