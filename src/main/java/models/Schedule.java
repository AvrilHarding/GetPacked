package models;

import lombok.Data;

import java.util.UUID;

@Data
public class Schedule {
    private String trip_name;
    private String restaurant_name;
    private String activity_name;

    public Schedule(String trip_name, String restaurant_name, String activity_name) {
        this.trip_name = trip_name;
        this.restaurant_name = restaurant_name;
        this.activity_name = activity_name;

    }
}
