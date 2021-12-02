package com.store.service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.store.service.dao.Product;
import com.store.service.dao.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository product , RepositoryRestConfiguration configuration) {
		return args -> {
			configuration.exposeIdsFor(Product.class);
			product.save(new Product(null,"ps5","2000",2000));
			product.save(new Product(null,"ps5","2000",2000));
			product.save(new Product(null,"ps5","2000",2000));
			product.save(new Product(null,"ps5","2000",2000));
			product.save(new Product(null,"ps5","2000",2000));
			product.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
	}

}
