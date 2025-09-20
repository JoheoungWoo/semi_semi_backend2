package com.semi_semi_backend11.semisemi.service;

import com.semi_semi_backend11.semisemi.dto.BookDto;
import com.semi_semi_backend11.semisemi.entity.Book;
import com.semi_semi_backend11.semisemi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository repository;

    public BookDto toDto(Book book){
        return BookDto.builder()
                    .isbn(book.getIsbn())
                    .title(book.getTitle())
                    .genre(book.getGenre())
                    .is_available(book.getIs_Available())
                    .publication_year(book.getPublicationYear())
                    .author(book.getAuthor())
                    .content(book.getContent())
                    .publisher(book.getPublisher())
                    .build();
    }
    public Book toEntity(BookDto dto){
        return Book.builder()
                    .isbn(dto.getIsbn())
                    .title(dto.getTitle())
                    .genre(dto.getGenre())
                    .is_Available(dto.getIs_available())
                    .publicationYear(dto.getPublication_year())
                    .author(dto.getAuthor())
                    .content(dto.getContent())
                    .publisher(dto.getPublisher())
                    .build();
    }

    @Override
    public List<BookDto> findAllBook() {
        return repository.findAll().stream().map(i->toDto(i)).toList();
    }

    @Override
    public Optional<BookDto> findBook(String isbn) {
        Book book=repository.findById(isbn);
        return toDto(book);
    }
}
