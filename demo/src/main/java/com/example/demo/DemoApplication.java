package com.example.demo;

import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner{

	@Autowired
	Driver driver;

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		try (var session =driver.session())
		{
			session.run("MATCH (n) return n.title").list().forEach(r->{
				System.out.println(r.get("title"));
			});
		}
	}
}
