package com.example.codeclan.coursebooking.repositories;


import com.example.codeclan.coursebooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

   // Get the courses for a given rating


    List<Course> findByRating(int rating);

//    @Test
//    public void findRaidByLocation(){
//        List<Raid> found = raidRepository.findRaidByLocation("Tortuga");
//        assertEquals("Tortuga", found.get(0).getLocation());
//    }


    //Get all courses for a customer

    List<Course> findByBookingsCustomerId(Long id);

//    @Test
//    public void canFindAllRaidsForAGivenShip(){
//        Ship  foundShip = shipRepository.getOne(3L); // we know ship 3 has pirates that have raids.
//        List<Raid> foiundRaids = raidRepository.findByPiratesShip(foundShip);
}
