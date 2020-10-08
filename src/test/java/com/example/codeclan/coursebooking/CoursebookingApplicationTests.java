package com.example.codeclan.coursebooking;

import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.models.Course;
import com.example.codeclan.coursebooking.models.Customer;
import com.example.codeclan.coursebooking.repositories.BookingRepository;
import com.example.codeclan.coursebooking.repositories.CourseRepository;
import com.example.codeclan.coursebooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CoursebookingApplicationTests {


	@Autowired
	CourseRepository courseRepository;
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	CustomerRepository customerRepository;


	@Test
	public void canGetCoursesForRating(){

		List<Course> found = courseRepository.findByRating(5);
			assertEquals(1,found.size());

	}

	@Test

	public  void getAllCoursesForaCustomer(){

		List<Course> found = courseRepository.findByBookingsCustomerId(1L);
		assertEquals( 2,found.size());
	}


	@Test

	public void getBookingsForDate(){

		List<Booking> found = bookingRepository.findByDate("10/11/2020");
		assertEquals(1,found.size());
	}


    @Test

	public void getAllCustomersForACourse(){

		List<Customer> found = customerRepository.findByBookingsCourseId(1L);
		assertEquals(2,found.size());
	}


     @Test
	public void getAllCustomersInATownForCourse(){

		List<Customer> found = customerRepository.findByTownAndBookingsCourseId("Edinburgh",1L);
		assertEquals(2,found.size());
		assertEquals("Edinburgh",found.get(1).getTown());
	 }

	 @Test
	public void getCustomersOverAgeInTownForCourse(){

		List<Customer> found = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseId(35,"Glasgow",2L);
		assertEquals(1,found.size());
		assertEquals("Ally",found.get(0).getName());
	 }
}
