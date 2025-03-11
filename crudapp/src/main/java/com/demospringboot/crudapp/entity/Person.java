package com.demospringboot.crudapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "firstname") //ไม่ต้องระบุ @Column ก็ได้ เดี๋ยวมันจะเอาชื่อ property ไปสร้างเป็นชื่อ column เอง
    private String fname;

    @Column(name = "lastname")
    private  String lname;

    //default Constructor
    //Constructor ที่ว่างในคลาส Entity มีไว้เพื่อให้ JPA สามารถสร้างอินสแตนซ์(new object())ของคลาสได้เมื่อทำการแมปข้อมูลจากฐานข้อมูล
    public Person(){

    }

    //parameter Constructor
    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
