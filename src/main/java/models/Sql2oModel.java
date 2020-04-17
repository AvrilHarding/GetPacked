package models;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.UUID;

public class Sql2oModel implements Model {

    private Sql2o sql2o;

    public Sql2oModel(Sql2o sql2o) {
        this.sql2o = sql2o;

    }

    @Override
    public void createTrip(String trip_name, String destination) {
        try (Connection conn = sql2o.beginTransaction()) {
           UUID tripUuid = UUID.randomUUID();
            conn.createQuery("insert into trips(trip_id, trip_name, destination) VALUES (:trip_id, :trip_name, :destination)")
                    .addParameter("trip_id", tripUuid)
                    .addParameter("trip_name", trip_name)
                    .addParameter("destination", destination)
                    .executeUpdate();
                conn.commit();

        }

    }

    @Override
    public List<Hotel> getAllHotels() {
        try (Connection conn = sql2o.open()) {

            List<Hotel> hotel = conn.createQuery("select * from hotels")

                    .executeAndFetch(Hotel.class);
            return hotel;
        }
    }


    @Override
    public void addHotel(String hotel_name, String trip_name) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("update trips SET hotel_name = :hotel_name WHERE trip_name = :trip_name")
                    .addParameter("hotel_name", hotel_name)
                    .addParameter("trip_name", trip_name)
                    .executeUpdate();

        }

    }
}

