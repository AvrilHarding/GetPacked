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
    public void createTrip(String trip_name, String destination, String username) {
        try (Connection conn = sql2o.beginTransaction()) {
            UUID tripUuid = UUID.randomUUID();
            conn.createQuery("insert into trips(trip_id, trip_name, destination, username) VALUES (:trip_id, :trip_name, :destination, :username)")
                    .addParameter("trip_id", tripUuid)
                    .addParameter("trip_name", trip_name)
                    .addParameter("destination", destination)
                    .addParameter("username", username)
                    .executeUpdate();
            conn.commit();

        }
    }

    @Override
    public List<Hotel> getAllHotels(String destination) {
        try (Connection conn = sql2o.open()) {

            List<Hotel> hotel = conn.createQuery("select * from hotels where destination = :destination")
            .addParameter("destination", destination)
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
    public List<Restaurants> getAllRestaurants(String destination) {
        try (Connection conn = sql2o.open()) {

            List<Restaurants> restaurants = conn.createQuery("select * from restaurants where destination = :destination")
            .addParameter("destination", destination)
                    .executeAndFetch(Restaurants.class);
            return restaurants;
        }
    }

    @Override

    public List<Activities> getAllActivities(String destination) {
        try (Connection conn = sql2o.open()) {

            List<Activities> activities = conn.createQuery("select * from activities where destination = :destination")
            .addParameter("destination", destination)
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

//    @Override

//    public void createSchedule(String trip_name, String restaurant_name, String activity_name) {
//        try (Connection conn = sql2o.beginTransaction()) {
//            conn.createQuery("insert into schedules(trip_name, restaurant_name, activity_name) VALUES (:trip_name, :restaurant_name, :activity_name)")
//
//                    .addParameter("trip_name", trip_name)
//                    .addParameter("restaurant_name", restaurant_name)
//                    .addParameter("activity_name", activity_name)
//                    .executeUpdate();
//            conn.commit();
//
//        }
//    }

    @Override
    public void addRestaurants(String[] restaurant_names, String trip_name) {
        for (String strTemp :restaurant_names){
            try (Connection conn = sql2o.open()) {
                conn.createQuery("insert into schedules(trip_name, restaurant_name) VALUES (:trip_name, :restaurant_name)")
                        .addParameter("restaurant_name", strTemp)
                        .addParameter("trip_name", trip_name)
                        .executeUpdate();
            }
            System.out.println(strTemp);
        }

    }


    public void addActivities(String[] activity_names, String trip_name) {
        for (String strTemp2 :activity_names){
        try (Connection conn = sql2o.open()) {
            conn.createQuery("insert into schedules(trip_name, activity_name) VALUES (:trip_name, :activity_name)")
                    .addParameter("activity_name", strTemp2)
                    .addParameter("trip_name", trip_name)
                    .executeUpdate();
        }
        System.out.println(strTemp2);
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
    public List<Schedules> getSchedule() {
        try (Connection conn = sql2o.open()) {

            List<Schedules> schedule = conn.createQuery("select trip_name, restaurant_name, activity_name from schedules")

                    .executeAndFetch(Schedules.class);
            return schedule;
        }
    }

//    @Override
//    public void loginUser(String username) {
//        try (Connection conn = sql2o.open()) {
//            conn.createQuery("insert into trips(username) VALUES (:username)")
//                    .addParameter("username", username)
//                    .executeUpdate();
//
//        }
//    }

}
