package com.semi_semi_backend11.semisemi.dto;

import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BookDTO {

    private String isbn;
    private String title;
    private String author;
    private String content;
    private String publisher;
    private Integer publication_year;
    private String genre;
    private String is_available;



}
