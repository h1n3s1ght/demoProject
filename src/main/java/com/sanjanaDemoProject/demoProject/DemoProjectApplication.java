package com.sanjanaDemoProject.demoProject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoProjectApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}

	private void insertCustomers(CustomerRepository repository){
		repository.save(new Customer("sanjana@gmail.com","Sanjana","321-456-7890"));
		repository.save(new Customer("shika@gmail.com","Shika","543-532-6516"));
		repository.save(new Customer("pavan@gmail.com","Pavan","523-520-8036"));
		repository.save(new Customer("rohit@gmail.com","Rohit","524-765-4321"));
	}

	@Bean
	public CommandLineRunner run(CustomerRepository repository){
		return (args -> {
			insertCustomers(repository);
			System.out.println("\n \n" + repository.findAll() + "\n");
		});
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n \n<=========================================> \n<============>   WORKING   <==============>\n<=========================================>\n \n");
		logger.info("\n \n<==> The item with ID = 40001 ==> "+ entityManager.createNamedQuery("findItemById").setParameter("id", 40001L).getResultList() + "\n");
//		logger.info("\n \n<==>"+ entityManager.createNativeQuery("SELECT C.Item_Num FROM Ordered_Items AS C WHERE C.Order_Num = : 60001L"), )  +"<==>")
	}
}
