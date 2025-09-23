package com.semi_semi_backend11.semisemi.service.notice;

import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;
import com.semi_semi_backend11.semisemi.dto.NoticeDto;

import java.util.List;
import java.util.Optional;

public interface NoticeService {
    List<NoticeDto> findAllNotice();
    Optional<NoticeDto> findNotice(Integer noticeId);
}
