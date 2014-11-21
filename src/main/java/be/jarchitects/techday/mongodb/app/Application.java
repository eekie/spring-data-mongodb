package be.jarchitects.techday.mongodb.app;

import be.jarchitects.techday.mongodb.app.domain.UserRepository;
import be.jarchitects.techday.mongodb.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration()
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("app started");
//		userRepository.deleteAll();
//
//		// save a couple of users
//		userRepository.save(new User("Tom", "Eekman", "tee"));
//		userRepository.save(new User("Ruhne", "Eekman", "ree"));
//		userRepository.save(new User("Ferre", "Eekman", "fee"));
//
//		// fetch all users
//		System.out.println("Users found with findAll():");
//		System.out.println("-------------------------------");
//		for (User user : userRepository.findAll()) {
//			System.out.println(user);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Users found with findByFirstName('Ferre'):");
//		System.out.println("--------------------------------");
//		System.out.println(userRepository.findByFirstName("Ferre"));
//
//		System.out.println("Users found with findByLastName('Eekman'):");
//		System.out.println("--------------------------------");
//		for (User user : userRepository.customQuery()) {
//			System.out.println(user);
//		}
		System.out.println("app finished");
	}

}
