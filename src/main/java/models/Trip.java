package models;

import java.util.UUID;

import lombok.Data;
@Data
public class Trip {
    private UUID trip_id;
    private String trip_name;
    private String destination;
    private String hotel_name;

    public Trip(UUID trip_id, String trip_name, String destination) {
        this.trip_id = trip_id;
        this.trip_name = trip_name;
        this.destination = destination;
        this.hotel_name = null;
    }

}
