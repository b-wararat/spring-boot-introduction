package com.demospringboot.crudapp;

import com.demospringboot.crudapp.entity.Person;
import com.demospringboot.crudapp.repository.PersonDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudappApplication.class, args);
	}
	@Bean
	//เอาตัว interface(PersonDAO) มาใช้เป็น parameter
	public CommandLineRunner commandLineRunner(PersonDAO dao){
		return  runner -> {
			updateData(dao);
		};
	}

	public void savetData(PersonDAO dao){
		Person person = new Person("wararat","jankrajang");
		dao.save(person);
		System.out.println("Insert Completed");
	}

	public void  deleteData(PersonDAO dao){
		int id=1;
		dao.delete(id);
		System.out.println("Delete Completed");
	};

	public void getData(PersonDAO dao){
		int id = 2;
		Person person = dao.get(id);
		System.out.println(person);
	}

	public void getAllData(PersonDAO dao){
		List<Person> personList = dao.getAll();
		for (Person person : personList){
			System.out.println(person);
		}
	}

	public void updateData(PersonDAO dao){
		int id = 2;
		Person myPerson = dao.get(id);
		myPerson.setFname("Bee");
		myPerson.setLname("JKJ");
		dao.update(myPerson);
		System.out.println("Update Completed");
	}
}
