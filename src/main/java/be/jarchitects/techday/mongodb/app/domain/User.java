package be.jarchitects.techday.mongodb.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by tom on 9/11/14.
 */
@Document
public class User {

    private String firstName;
    private String lastName;

    @Id
    private String login;

    public User(String firstName, String lastName, String login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return login+":"+firstName+" "+lastName;
    }

}
