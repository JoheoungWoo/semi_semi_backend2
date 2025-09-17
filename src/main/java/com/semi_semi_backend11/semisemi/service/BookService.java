package com.semi_semi_backend11.semisemi.service;

import com.semi_semi_backend11.semisemi.dto.BookDto;
import java.util.List;

public interface BookService {
    List<BookDto> findAllBook();
    
}
