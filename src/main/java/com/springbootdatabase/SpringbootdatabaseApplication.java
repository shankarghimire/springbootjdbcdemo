package com.springbootdatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootdatabase.jdbc.PersonJdbcDao;

@SpringBootApplication
public class SpringbootdatabaseApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao personDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdatabaseApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Persons=>{}", personDao.findAll());
	}

}
