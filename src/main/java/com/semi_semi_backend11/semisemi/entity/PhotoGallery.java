package com.semi_semi_backend11.semisemi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "PHOTO_GALLERY")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gallery_id")
    private Integer galleryId;
    private String writer;
    private String title;
    private String content;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
