package com.example.codeclan.coursebooking.components;


import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.models.Course;
import com.example.codeclan.coursebooking.models.Customer;
import com.example.codeclan.coursebooking.repositories.BookingRepository;
import com.example.codeclan.coursebooking.repositories.CourseRepository;
import com.example.codeclan.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Course course1 = new Course("Python","Edinburgh",4);
        courseRepository.save(course1);

        Course course2 = new Course("Java","Inverness",5);
        courseRepository.save(course2);

        Course course3 = new Course("Python","Glasgow",4);
        courseRepository.save(course3);


        Customer customer1 = new Customer("Jonny","Edinburgh",29);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Anna","Edinburgh",40);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Ally","Glasgow",42);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("05/10/2020",customer1,course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("10/11/2020",customer2,course1);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("11/10/2020",customer3,course2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("12/10/2020",customer1,course2);
        bookingRepository.save(booking4);


    }

}
