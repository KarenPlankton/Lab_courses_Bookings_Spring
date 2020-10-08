package com.example.codeclan.coursebooking.controllers;

import com.example.codeclan.coursebooking.models.Customer;
import com.example.codeclan.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;




    @GetMapping
    public ResponseEntity<List<Customer>> getAllCourses(
            @RequestParam(name = "course_id", required = false) Long id,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        if (id != null && town !=null && age !=null ) {
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseId(age,town,id), HttpStatus.OK);
        }

        if (id != null && town != null) {
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseId(town,id), HttpStatus.OK);
        }
        if (id != null ) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(id), HttpStatus.OK);
        }

            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }


    }



