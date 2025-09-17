package com.semi_semi_backend11.semisemi.dto;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BookDto {

    private String isbn;
    private String title;
    private String author;
    private String content;
    private String publisher;
    private Integer publication_year;
    private String genre;
    private String is_available;



}
