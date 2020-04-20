package models;


import java.util.List;
import java.util.UUID;

public interface Model {

    void createTrip(String trip_name, String destination);
    List getAllHotels();
    void addHotel(String hotel_name, String trip_name);
    List<Restaurants> getAllRestaurants();
    List<Activities> getAllActivities();
    List getAllTrips();


    void createSchedule(String trip_name, String restaurant_name, String activity_name);

    void addRestaurants(String restaurant_name, String trip_name);

    List<Schedule> getSchedule();

    void addUser(String first_name, String last_name, String username, String email_address, String password);

}
