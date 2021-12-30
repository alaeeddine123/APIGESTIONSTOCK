package com.gestionstock;

import com.gestionstock.model.Product;
import com.gestionstock.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gestionstock"})
public  class AspirationsApplication {


	public static void main(String[] args) {

		SpringApplication.run(AspirationsApplication.class, args);
	}


	@Bean
	CommandLineRunner run(ProductRepo productRep){

		return  args -> {
			productRep.save(new Product(null ,
							"product1" ,
							"blue" ,
							"shoes" ,
							"fashion" ,
							11,
							10,
							123,
							"http://locahost:8080/product/image/product1.png" ));
		};
	}

}
