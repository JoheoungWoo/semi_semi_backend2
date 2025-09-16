package com.semi_semi_backend11.semisemi.service;

import com.semi_semi_backend11.semisemi.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<BookDTO> findAllBook();
}
