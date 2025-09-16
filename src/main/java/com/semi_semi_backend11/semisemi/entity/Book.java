package com.semi_semi_backend11.semisemi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
public class Book {
    @Id
    private String isbn;

    private String title;
    private String author;
    private String content;
    private String publisher;
    private Integer publication_year;
    private String genre;
    private String is_available;



}
