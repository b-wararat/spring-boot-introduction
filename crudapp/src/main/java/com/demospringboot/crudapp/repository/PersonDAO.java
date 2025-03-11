package com.demospringboot.crudapp.repository;

import com.demospringboot.crudapp.entity.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person person);
    void delete(int id);
    Person get(int id);
    List<Person> getAll();
    void update(Person person);
}
