package models;


import java.util.List;

public interface Model {

    void createTrip(String trip_name, String destination);
    List getAllHotels();
    void addHotel(String hotel_name);
}


