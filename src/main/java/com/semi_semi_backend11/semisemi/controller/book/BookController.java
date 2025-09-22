package com.semi_semi_backend11.semisemi.controller.book;

import com.semi_semi_backend11.semisemi.dto.BookDto;
import com.semi_semi_backend11.semisemi.service.book.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(
        origins = "http://localhost:3000",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH,RequestMethod.OPTIONS},
        allowedHeaders = "*")
public class BookController {
    @Autowired

    private BookService service;

    @GetMapping("/list")
    public ResponseEntity<List<BookDto>> bookDTOList(){
        return ResponseEntity.ok(service.findAllBook());
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<BookDto> bookDetail(@PathVariable("isbn") String isbn){
        Optional<BookDto> optionalDto = service.findBook(isbn);
        if(optionalDto.isPresent()){
            return ResponseEntity.ok(optionalDto.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
