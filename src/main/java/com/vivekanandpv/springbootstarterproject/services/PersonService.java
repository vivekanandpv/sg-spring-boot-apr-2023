package com.vivekanandpv.springbootstarterproject.services;

import com.vivekanandpv.springbootstarterproject.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getById(int id);
    Person create(Person person);
    Person update(int id, Person person);
    void delete(int id);
}
