package models;

import lombok.Data;

@Data
public class Restaurants {
    private int restaurant_id;
    private String restaurant_name;
    private String restaurant_descr;
    private int restaurant_star_rating;
    private String destination;
    private String cuisine_tags;

    public Restaurants(int restaurant_id, String restaurant_name, String restaurant_descr, int restaurant_star_rating, String destination, String cuisine_tags) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.restaurant_descr = restaurant_descr;
        this.restaurant_star_rating = restaurant_star_rating;
        this.destination = destination;
        this.cuisine_tags = cuisine_tags;
    }
}
