package com.example.springbootsecurity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.ArrayList;


public interface ProductRepository extends CrudRepository<Product, Long>{
//    ArrayList<Product> findByTitle(String title);

    @Query(value = "SELECT * FROM product_data p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(p.genre) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(p.authorartist) LIKE LOWER(CONCAT('%',:searchTerm, '%'))",
            nativeQuery = true
    )
    ArrayList<Product> findBySearchTermNative(@Param("searchTerm") String searchTerm);



}
