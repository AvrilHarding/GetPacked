package models;

import lombok.Data;

import java.util.UUID;
@Data
public class Hotel {
    private int hotel_id;
    private String hotel_name;
    private String hotel_descr;
    private String room_name;
    private  int room_occupancy_limit;
    private int price_pppn;
    private int hotel_star_rating;
    private String destination;

    public Hotel(int hotel_id, String hotel_name, String hotel_descr, String room_name, int room_occupancy_limit, int price_pppn, int hotel_star_rating, String destination) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_descr = hotel_descr;
        this.room_name = room_name;
        this.room_occupancy_limit = room_occupancy_limit;
        this.price_pppn = price_pppn;
        this.hotel_star_rating = hotel_star_rating;
        this.destination = destination;
    }

}


