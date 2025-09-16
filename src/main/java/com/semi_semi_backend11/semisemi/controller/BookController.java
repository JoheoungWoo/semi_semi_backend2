package com.semi_semi_backend11.semisemi.controller;

import com.semi_semi_backend11.semisemi.dto.BookDTO;
import com.semi_semi_backend11.semisemi.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BookController {
    @Autowired

    private BookService service;

    @GetMapping("/list")
    public List<BookDTO> bookDTOList(){
        return service.findAllBook();
    }
}
