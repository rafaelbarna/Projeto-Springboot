package com.springproject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springproject.course.entities.Order;
import com.springproject.course.entities.User;
import com.springproject.course.repositories.OrderRepository;
import com.springproject.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	// Executa em quando a aplicação for INICIADA
	@Override
	public void run(String... args) throws Exception {
		
		// ID definido pelo Banco de Dados
		User u1 = new User(null, "Rafa", "rafa@mail.com", "900000000", "123456");
		User u2 = new User(null, "Canna", "canna@mail.com", "690000691", "123456");
		
		Order o1 = new Order(null, Instant.parse("2021-02-09T15:50:00Z"), u1);
		Order o2 = new Order(null, Instant.parse("2021-02-09T16:43:00Z"), u2);
		Order o3 = new Order(null, Instant.parse("2021-02-09T17:53:00Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
