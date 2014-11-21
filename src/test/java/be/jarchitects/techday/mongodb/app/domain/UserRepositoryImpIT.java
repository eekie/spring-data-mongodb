package be.jarchitects.techday.mongodb.app.domain;


import be.jarchitects.techday.mongodb.app.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Pattern;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class UserRepositoryImpIT {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRepo() throws Exception {
        userRepository.deleteAll();
        assertThat(userRepository.findAll()).hasSize(0);
        userRepository.save(new User("Daffy", "Duck", "daffy"));
        userRepository.save(new User("Donald", "Duck", "donald"));
        userRepository.save(new User("Minnie", "Mouse", "minnie"));
        userRepository.save(new User("Mickey", "Mouse", "mickey"));
        userRepository.save(new User("Mickey", "Mouse", "mickey"));  // !!
        assertThat(userRepository.findAll()).hasSize(4);
        assertThat(userRepository.findByFirstName("Daffy").getFirstName()).isEqualTo("Daffy");
        assertThat(userRepository.customQuery()).hasSize(2);
        assertThat(userRepository.groupByLastName(".*")).hasSize(2);
        assertThat(userRepository.groupByLastName("Duck")).hasSize(1);
        assertThat(userRepository.groupByLastName("Duck").get(0).getId()).isEqualTo("Duck");
        assertThat(userRepository.groupByLastName("Duck").get(0).getCount()).isEqualTo(2);
        assertThat(userRepository.groupByLastName("Mouse")).hasSize(1);
        System.out.println(userRepository.groupByLastName(".*").get(0));
        System.out.println(userRepository.groupByLastName(".*").get(1));

        assertThat(userRepository.basicJsonQuery()).hasSize(2);
    }

}