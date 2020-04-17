package models;

import lombok.Data;

@Data
public class Activities {
    private int activity_id;
    private String activity_name;
    private String activity_descr;
    private String destination;
    private int date;
    private String activity_tags;

    public Activities(int activity_id, String activity_name, String activity_descr, String destination, int date, String activity_tags) {
        this.activity_id = activity_id;
        this.activity_name = activity_name;
        this.activity_descr = activity_descr;
        this.destination = destination;
        this.date = date;
        this.activity_tags = activity_tags;
    }
}

