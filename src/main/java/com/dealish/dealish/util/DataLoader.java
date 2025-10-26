package com.dealish.dealish.util;

import com.dealish.dealish.model.*;
import com.dealish.dealish.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RestaurantRepository restaurantRepo;
    @Autowired
    private MenuItemRepository menuRepo;
    @Autowired
    private OfferRepository offerRepo;
    @Autowired
    private FeedbackRepository feedbackRepo;
    @Autowired
    private OrderRepository orderRepo;

    @Override
    public void run(String... args) throws Exception {
        // Users
        User u1 = new User(); u1.setName("Kiran Kumar"); u1.setEmail("kiran@example.com"); u1.setPhone("9876543210"); u1.setLocation("Hyderabad"); u1.setCreatedAt(LocalDateTime.of(2025,10,25,10,0));
        User u2 = new User(); u2.setName("Sneha Reddy"); u2.setEmail("sneha@example.com"); u2.setPhone("9123456780"); u2.setLocation("Secunderabad"); u2.setCreatedAt(LocalDateTime.of(2025,10,25,10,5));
        userRepo.save(u1); userRepo.save(u2);

        // Restaurants
        Restaurant r1 = new Restaurant(); r1.setName("Spice Hub"); r1.setCity("Hyderabad"); r1.setCuisineType("Indian"); r1.setRating(4.6); r1.setOpenTime("10:00 AM"); r1.setCloseTime("11:00 PM"); r1.setLatitude(17.3850); r1.setLongitude(78.4867); r1.setCreatedAt(LocalDateTime.now());
        Restaurant r2 = new Restaurant(); r2.setName("Pizza Lounge"); r2.setCity("Secunderabad"); r2.setCuisineType("Italian"); r2.setRating(4.2); r2.setOpenTime("11:00 AM"); r2.setCloseTime("10:00 PM"); r2.setLatitude(17.4399); r2.setLongitude(78.4983); r2.setCreatedAt(LocalDateTime.now());
        restaurantRepo.save(r1); restaurantRepo.save(r2);

        // Menu items
        MenuItem m1 = new MenuItem(); m1.setRestaurant(r1); m1.setItemName("Butter Chicken"); m1.setCategory("Main Course"); m1.setPrice(250.0); m1.setAvailability("Available"); m1.setDescription("Creamy chicken in tomato gravy"); m1.setImageUrl("image1.jpg");
        MenuItem m2 = new MenuItem(); m2.setRestaurant(r1); m2.setItemName("Paneer Tikka"); m2.setCategory("Starter"); m2.setPrice(180.0); m2.setAvailability("Available"); m2.setDescription("Grilled paneer with spices");
        menuRepo.save(m1); menuRepo.save(m2);

        // Offers
        Offer o1 = new Offer(); o1.setRestaurant(r1); o1.setTitle("Weekend Feast"); o1.setDescription("20% off on all main courses"); o1.setDiscountPercent(20); o1.setStartDate(LocalDate.of(2025,10,26)); o1.setEndDate(LocalDate.of(2025,10,28)); o1.setActive(true);
        offerRepo.save(o1);

        // Feedback
        Feedback f1 = new Feedback(); f1.setRestaurant(r1); f1.setUser(u1); f1.setRating(5); f1.setComment("Excellent taste and quick delivery!"); f1.setCreatedAt(LocalDateTime.of(2025,10,25,12,30));
        feedbackRepo.save(f1);

        // Orders
        OrderEntity ord1 = new OrderEntity(); ord1.setUser(u1); ord1.setRestaurant(r1); ord1.setTotalAmount(500.0); ord1.setOrderTime(LocalDateTime.of(2025,10,25,13,30)); ord1.setStatus("Delivered");
        orderRepo.save(ord1);
    }
}
