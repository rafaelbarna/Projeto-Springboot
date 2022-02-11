package com.springproject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springproject.course.entities.Category;
import com.springproject.course.entities.Order;
import com.springproject.course.entities.User;
import com.springproject.course.entities.enums.OrderStatus;
import com.springproject.course.repositories.CategoryRepository;
import com.springproject.course.repositories.OrderRepository;
import com.springproject.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// Injeção de Dependência
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Executa quando a aplicação for INICIADA
	@Override
	public void run(String... args) throws Exception {
		
		// ID definido pelo Banco de Dados
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Rafa", "rafa@mail.com", "900000000", "123456");
		User u2 = new User(null, "Canna", "canna@mail.com", "690000691", "123456");
		
		Order o1 = new Order(null, Instant.parse("2021-02-09T15:50:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-02-09T16:43:00Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-02-09T17:53:00Z"), OrderStatus.SHIPPED, u1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
