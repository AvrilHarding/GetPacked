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

    @Override
    public List<Restaurants> getAllRestaurants() {
        try (Connection conn = sql2o.open()) {

            List<Restaurants> restaurants = conn.createQuery("select * from restaurants")

                    .executeAndFetch(Restaurants.class);
            return restaurants;
        }
    }

    @Override

    public List<Activities> getAllActivities() {
        try (Connection conn = sql2o.open()) {

            List<Activities> activities = conn.createQuery("select * from activities")

                    .executeAndFetch(Activities.class);
            return activities;
        }
    }


    public List<Trip> getAllTrips() {
        try (Connection conn = sql2o.open()) {

            List<Trip> trips = conn.createQuery("select trip_name, destination, hotel_name from trips")

                    .executeAndFetch(Trip.class);
            return trips;
        }
    }

    @Override

    public void createSchedule(String trip_name, String restaurant_name, String activity_name) {
        try (Connection conn = sql2o.beginTransaction()) {
            conn.createQuery("insert into schedules(trip_name, restaurant_name, activity_name) VALUES (:trip_name, :restaurant_name, :activity_name)")

                    .addParameter("trip_name", trip_name)
                    .addParameter("restaurant_name", restaurant_name)
                    .addParameter("activity_name", activity_name)
                    .executeUpdate();
            conn.commit();

        }
    }

    @Override
    public void addRestaurants(String restaurant_name, String trip_name) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("update schedules SET restaurant_name = :restaurant_name WHERE trip_name = :trip_name")
                    .addParameter("restaurant_name", restaurant_name)
                    .addParameter("trip_name", trip_name)
                    .executeUpdate();

        }
    }

    public void addUser(String first_name, String last_name, String username, String email_address, String password) {
        try (Connection conn = sql2o.open()) {
            UUID userUuid = UUID.randomUUID();
            conn.createQuery("insert into users(user_id, first_name, last_name, username, email_address, password) VALUES (:user_id, :first_name, :last_name, :username, :email_address, :password)")
                    .addParameter("user_id", userUuid)
                    .addParameter("first_name", first_name)
                    .addParameter("last_name", last_name)
                    .addParameter("username", username)
                    .addParameter("email_address", email_address)
                    .addParameter("password", password)
                    .executeUpdate();

        }
    }


    @Override
    public List<Schedule> getSchedule() {
        try (Connection conn = sql2o.open()) {

            List<Schedule> schedule = conn.createQuery("select trip_name, restaurant_name from schedules")

                    .executeAndFetch(Schedule.class);
            return schedule;
        }
    }


}
