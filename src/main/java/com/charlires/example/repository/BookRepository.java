package com.charlires.example.repository;

import com.charlires.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by carlos_andonaegui on 3/14/14.
 */
@Repository
@RestResource(rel = "books", path = "books")
public interface BookRepository extends JpaRepository<Book, Integer> {

}
