package com.example.springbootsecurity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.ArrayList;


public interface ProductRepository extends CrudRepository<Product, Long>{


    @Query(value = "SELECT * FROM product_data p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(p.genre) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(p.authorartist) LIKE LOWER(CONCAT('%',:searchTerm, '%'))"+
            "ORDER BY genre ASC",
            nativeQuery = true
    )
    ArrayList<Product> findBySearchTermNative(@Param("searchTerm") String searchTerm);

    ArrayList<Product> findByUsername(String username);




//    ArrayList<Product> findByTitle(String title);







}
