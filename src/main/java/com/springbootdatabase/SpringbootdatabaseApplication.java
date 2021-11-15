package com.springbootdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootdatabase.entities.Person;
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
		logger.info("All Users=>{}", personDao.findAll());
		logger.info( "User Id 102 =>{}", personDao.findById(102));
		logger.info( "Deleted User Id 102 =>{}", personDao.deleteById(102));
		logger.info( "Inserted  User Id 104 =>{}", personDao.insertPerson(
				new Person(104,"Test","Test-Location", new Date())));
		
		logger.info( "Updated  User Id 101 =>{}", personDao.updatePerson(
				new Person(101,"Shankar Ghimire","Chitwan", new Date())));
	}

}
