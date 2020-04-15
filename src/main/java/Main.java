import models.Model;
import models.Sql2oModel;
import org.apache.log4j.BasicConfigurator;
import org.flywaydb.core.Flyway;
import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.UUID;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {

    public static void main(String[] args) {
        String dbName = "getpacked";
        for(String a:args) {
            dbName = a;
        }
        System.out.println(dbName);
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/"+dbName, null, null).load();
        flyway.migrate();

        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/" + dbName, null, null, new PostgresQuirks() {
            {
                // make sure we use default UUID converter.
                converters.put(UUID.class, new UUIDConverter());
            }
        });

        Model model = new Sql2oModel(sql2o);



        get("/dashboard", (req, res) -> {
            System.out.println("Hello Avril");

//            HashMap dashboard = new HashMap();

            return new ModelAndView(new HashMap(), "templates/dashboard.vtl");
        }, new VelocityTemplateEngine());


        get("/newtrip", (req, res) -> {

//            HashMap trip = new HashMap();

            return new ModelAndView(new HashMap(), "templates/newtrip.vtl");
        }, new VelocityTemplateEngine());

        post("/newtrip", (request, response) -> {

            String trip_name = request.queryParams("trip_name_1");
            String destination = request.queryParams("destination_1");
            model.createTrip(trip_name, destination);

            response.redirect("/pickhotel");
            return null;

        });

        get("/pickhotel", (req, res) -> {

//
            return new ModelAndView(new HashMap(), "templates/pickhotel.vtl");
        }, new VelocityTemplateEngine());


        get("/yourtrips", (req, res) -> {


//            HashMap yourtrips = new HashMap();


            return new ModelAndView(new HashMap(), "templates/yourtrips.vtl");
        }, new VelocityTemplateEngine());


        get("/schedule", (req, res) -> {


//            HashMap schedule = new HashMap();


            return new ModelAndView(new HashMap(), "templates/schedule.vtl");
        }, new VelocityTemplateEngine());
    }
}
