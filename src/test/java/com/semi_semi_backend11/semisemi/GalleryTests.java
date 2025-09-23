package com.semi_semi_backend11.semisemi;

import com.semi_semi_backend11.semisemi.service.photogallery.PhotogalleryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GalleryTests {
    @Autowired
    PhotogalleryService service;

    @Test
    public void findAllTest() {
        service.findAllGallery()
                .forEach(photoGallery -> System.out.println(photoGallery));
    }

    @Test
    public void findByIdTest() {
        var result = service.findGallery(1);
        if(result.isEmpty()){
            System.out.println("실패");
            return;
        }

        System.out.println(result.get());
    }

}
