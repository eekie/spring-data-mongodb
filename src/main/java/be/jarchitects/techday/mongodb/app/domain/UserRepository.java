package be.jarchitects.techday.mongodb.app.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by tom on 9/11/14.
 */
public interface UserRepository extends MongoRepository<User, String>, CustomUserRepository {

    User findByFirstName(String firstName);

}
