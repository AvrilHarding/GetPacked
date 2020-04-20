package models;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private UUID user_id;
    private String first_name;
    private String last_name;
    private String username;
    private String email_address;
    private String password;

    public User(UUID user_id, String first_name, String last_name, String username, String email_address, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email_address = email_address;
        this.password = password;
    }
}
