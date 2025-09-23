package com.semi_semi_backend11.semisemi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {
    private Integer noticeId;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Integer viewCount;
}
