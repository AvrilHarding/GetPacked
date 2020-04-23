package models;


import java.util.List;

public interface Model {

    void createTrip(String trip_name, String destination, String username);

    List<Hotel> getAllHotels(String destination);

    void addHotel(String hotel_name, String trip_name);
    List<Restaurants> getAllRestaurants(String destination);
    List<Activities> getAllActivities(String destination);
    List getAllTrips(String username);

    void addRestaurants(String[] restaurant_name, String trip_name);

    void addActivities(String[] activity_name, String trip_name);

    void addUser(String first_name, String last_name, String username, String email_address, String password);

    List<Schedules> getOneSchedule(String trip_name);

}
