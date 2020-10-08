package com.example.codeclan.coursebooking.controllers;


import com.example.codeclan.coursebooking.models.Course;
import com.example.codeclan.coursebooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "customer_id", required = false) Long id
    ) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }

        if (id != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerId(id), HttpStatus.OK);


        }
        return  new ResponseEntity<>(courseRepository.findAll(),HttpStatus.OK);


    }

}
