package com.semi_semi_backend11.semisemi.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PhotoGalleryDto {
    private Integer galleryId;
    private String writer;
    private String title;
    private String content;
    private String photoUrl;
    private LocalDateTime createdAt;
    private MultipartFile photo;
}
