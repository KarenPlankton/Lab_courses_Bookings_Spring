package com.example.codeclan.coursebooking.repositories;

import com.example.codeclan.coursebooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository <Booking,Long> {


//Get all bookings for a given date

    List<Booking> findByDate (String date);



}