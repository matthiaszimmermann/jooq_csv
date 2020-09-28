package com.example.jooqcsv;

import org.jooq.DSLContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringJooqCsvApplication implements CommandLineRunner  {
	
	@Autowired
	private DSLContext dsl;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringJooqCsvApplication.class, args);
	}
	
	@Override
    public void run(String...args) throws Exception {
		System.out.println("hello");
		System.out.println(dsl);
		
		AuthorInserter ai = new AuthorInserter(dsl);
		ai.insertNumberOfRecords(5);		
		ai.printAuthors();
		ai.printNumberOfAuthors();
		ai.printAuthorsAsCsv();
	}
}
