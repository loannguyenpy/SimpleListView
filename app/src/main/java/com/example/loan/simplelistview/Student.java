package com.example.loan.simplelistview;

import java.io.Serializable;

/**
 * Created by LOAN on 7/12/2016.
 */
public class Student implements Serializable {
    private String name;
    private int age;
    private String country;
    private String gender;
    public Student()
    {

    }
    public Student(String n, int a, String c, String g)
    {
        this.name=n;
        this.age=a;
        this.country=c;
        this.gender=g;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
