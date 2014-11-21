package be.jarchitects.techday.mongodb.app.domain;

import java.util.List;

/**
 * Created by tom on 9/11/14.
 */
interface CustomUserRepository {

    List<User> customQuery();

    List<User> basicJsonQuery();

    List<LastNameStats> groupByLastName(String lastNameRegex);



}
