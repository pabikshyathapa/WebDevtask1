package com.example.demo.repo;

import com.example.demo.entity.book;
import com.example.demo.pojo.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<book, Integer> {


    @Query(nativeQuery = true, value = "select id, ground_id as groundId, user_id as userId,date from book_information")
    List<BookProjection> findAllData();
}