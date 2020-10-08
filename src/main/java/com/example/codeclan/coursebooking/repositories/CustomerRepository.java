package com.example.codeclan.coursebooking.repositories;


import com.example.codeclan.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    //Get all customers for a given course

    List<Customer> findByBookingsCourseId(Long id);


    //Get all customers in a given town,for a given course

    List<Customer> findByTownAndBookingsCourseId(String town, Long id);

    //Get all customers over certain age for a given course

   List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseId(int age, String town,Long id );

}
