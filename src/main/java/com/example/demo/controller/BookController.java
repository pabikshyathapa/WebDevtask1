package com.example.demo.controller;
import com.example.demo.entity.book;
import com.example.demo.pojo.BookPojo;
import com.example.demo.pojo.BookProjection;
import com.example.demo.pojo.GlobalApilResponse;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public List<BookProjection> findAll() {
        return this.bookService.findAll();
    }


    @GetMapping("/list2")
    public List<book> findAll2() {
        return this.bookService.findAll2();
    }


    @PostMapping("/save")
    public GlobalApilResponse<Integer> saveBook(@RequestBody @Valid BookPojo bookPojo) {
        GlobalApilResponse<Integer> globalApiResponse= new GlobalApilResponse<>();
        Integer bookId= bookService.saveBook(bookPojo);
        globalApiResponse.setData(bookId);
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("data saved successfully");

        return globalApiResponse;
    }


    @PutMapping("/update")
    public void bookUpdate(@RequestBody BookPojo bookPojo) {
        bookService.saveBook(bookPojo);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.deleteById(id);
    }

    @GetMapping("/getById/{id}")
    public book findById(@PathVariable Integer id) {
        return this.bookService.findById(id);
    }

}
