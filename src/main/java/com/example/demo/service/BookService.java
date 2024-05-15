package com.example.demo.service;


import com.example.demo.entity.book;
import com.example.demo.pojo.BookPojo;
import com.example.demo.pojo.BookProjection;

import java.util.List;

public interface BookService {

    Integer saveBook(BookPojo bookPojo);

    List<BookProjection> findAll();
    List<book> findAll2();

    book findById(Integer id);

    void deleteById(Integer id);

}