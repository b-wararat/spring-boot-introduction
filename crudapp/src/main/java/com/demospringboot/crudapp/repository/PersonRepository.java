package com.demospringboot.crudapp.repository;

import com.demospringboot.crudapp.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class PersonRepository implements PersonDAO{
    private EntityManager entityManager;

    @Autowired //Spring จะช่วยสร้างอินสแตนซ์ของ EntityManager ให้อัตโนมัติ
    public PersonRepository(EntityManager entityManager) {
        //ถ้าไม่ใช้ @Autowired จะต้องเขียนแบบนี้ this.entityManager = new EntityManager();
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //ใส่เมื่อมีการเปลี่ยนแปลงข้อมูล เช่นพวก inset update delete
    public void save(Person person) {
        entityManager.persist(person); //persist() → ใช้สำหรับ สร้าง (INSERT) ข้อมูลใหม่
    }

    @Override
    @Transactional
    public void delete(int id) {
        Person person = entityManager.find(Person.class,id);
        entityManager.remove(person);
    }

    @Override
    public Person get(int id) {
        return entityManager.find(Person.class,id);
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = entityManager.createQuery("FROM Person",Person.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Person person) {
        entityManager.merge(person);
    }
}
