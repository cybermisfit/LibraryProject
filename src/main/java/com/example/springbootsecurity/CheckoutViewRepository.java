//package com.example.springbootsecurity;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import java.util.ArrayList;
//
//public interface CheckoutViewRepository extends CrudRepository<CheckoutView,Long>{
//
//   @Query(value = "select l.id as id,p.title,firstname ,lastname ,dateborrowed, datereturned, username " +
//           "   from product_data p " +
//           "   inner join checkoutview l " +
//           "   inner join student_data s " +
//           "   on l.product_id = p.id and l.student_id = s.id WHERE " +
//           "LOWER(s.username) LIKE LOWER(CONCAT('%',:username, '%'))",
//           nativeQuery = true
//   )
//
//   ArrayList<CheckoutView> findByusername(@Param("username") String username);
//
//}
