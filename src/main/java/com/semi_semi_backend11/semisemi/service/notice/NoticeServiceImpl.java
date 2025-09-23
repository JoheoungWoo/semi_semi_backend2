package com.semi_semi_backend11.semisemi.service.notice;

import com.semi_semi_backend11.semisemi.dto.NoticeDto;
import com.semi_semi_backend11.semisemi.entity.Notice;
import com.semi_semi_backend11.semisemi.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository repository;

    public NoticeDto toDto(Notice notice){
        return NoticeDto.builder()
                .noticeId(notice.getNoticeId())
                .writer(notice.getWriter())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .viewCount(notice.getViewCount())
                .build();
    }
    public Notice toEntity(NoticeDto dto){
        return Notice.builder()
                .noticeId(dto.getNoticeId())
                .writer(dto.getWriter())
                .title(dto.getTitle())
                .content(dto.getContent())
                .createdAt(dto.getCreatedAt())
                .viewCount(dto.getViewCount())
                .build();
    }

    @Override
    public List<NoticeDto> findAllNotice() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<NoticeDto> findNotice(Integer noticeId) {
        return repository.findById(noticeId).map(this::toDto);
    }
}
