package com.semi_semi_backend11.semisemi.repository;

import com.semi_semi_backend11.semisemi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
