package com.springboot.jpa.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jpa.test.dao.UserRepository;
import com.springboot.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepo = context.getBean(UserRepository.class);

//**************************** CREATE ********************************		
//		User user4 = new User();
//		user4.setName("Tejas");
//		user4.setCity("Uttur");
//		user4.setStatus("Student4");
//		
//		User newuser = userRepo.save(user4);
//		System.out.println(newuser);
		
//		User user1 = new User();
//		user1.setName("Prathmesh");
//		user1.setCity("Shirala");
//		user1.setStatus("Student1");
//		
//		User user2 = new User();
//		user2.setName("Abhi");
//		user2.setCity("Vita");
//		user2.setStatus("Student2");
//		
//		User user3 = new User();
//		user3.setName("Tejas");
//		user3.setCity("Ardal");
//		user3.setStatus("Student3");
//		
//		
//		List<User>users = List.of(user1,user2,user3);
//		Iterable<User>result = userRepo.saveAll(users);
//		
//		result.forEach(user->{
//			System.out.println(user);
//		});
		
//		***************************UPDATE*****************************
//		Optional<User>optional = userRepo.findById(2);
//		User user = optional.get();
//		
//		System.out.println(user);
//		user.setName("Prathmesh Salunkhe");
//		User result = userRepo.save(user);
//		System.out.println(result);
		
//		****************************READ*****************************
		Iterable <User>itr = userRepo.findAll();
		itr.forEach(user->{System.out.println(user);});
		System.out.println();
//		
//		*****************************DELETE**************************
//		userRepo.deleteById(2);
//		
//		Optional<User>optional1 = userRepo.findById(302);
//		User user1 = optional1.get();
//		Optional<User>optional2 = userRepo.findById(303);
//		User user2 = optional2.get();
//		Optional<User>optional3 = userRepo.findById(304);
//		User user3 = optional3.get();
//		
//		List<User>list = List.of(user1,user2,user3);
//		userRepo.deleteAll(list);
//		
//		userRepo.deleteAll();
		
//		System.out.println("After Deleting");
//		Iterable <User>itr1 = userRepo.findAll();
//		itr1.forEach(user->{System.out.println(user);});
		
//		*****************************FIND BY NAME QUERY METHODS******************************
		System.out.println("Finding data by name:Tejas ");
		List<User>ans = userRepo.findByName("Tejas");
		ans.forEach(user->{
			System.out.println(user);
		});
		System.out.println();

//		*****************************FIND BY NAME AND CITY QUERY METHODS******************************
		System.out.println("Finding data by name Tejas and city Ardal: ");
		List<User>ans1 = userRepo.findByNameAndCity("Tejas","Ardal");
		ans1.forEach(user->{
			System.out.println(user);
		});
		System.out.println();

//		*****************************FIND BY NAME AND CITY JPQL METHODS******************************
		System.out.println("Finding data by name Tejas and city Uttur by JPQL mehod: ");
		userRepo.getUserByNameAndCity("Tejas", "Uttur").forEach(e->System.out.println(e));
		System.out.println();

//		*****************************GETTING DATA BY SQL QUERY METHOD******************************
		System.out.println("GETTING DATA BY SQL QUERY METHOD: ");
		userRepo.getAllUsers().forEach(e->System.out.println(e));
		System.out.println();

	}
	
}
