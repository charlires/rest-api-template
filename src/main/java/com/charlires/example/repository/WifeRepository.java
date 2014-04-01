package com.charlires.example.repository;

import com.charlires.example.model.Wife;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by carlos_andonaegui on 3/31/14.
 */
@Repository
@RestResource(rel = "wife", path = "wife")
public interface WifeRepository extends PagingAndSortingRepository<Wife, Long> {


    
}
