package com.semi_semi_backend11.semisemi.service.book;

import com.semi_semi_backend11.semisemi.dto.BookDto;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> findAllBook();
    Optional<BookDto> findBook(String isbn);
}
