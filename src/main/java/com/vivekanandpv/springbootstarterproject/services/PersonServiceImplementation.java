package com.vivekanandpv.springbootstarterproject.services;

import com.vivekanandpv.springbootstarterproject.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImplementation implements PersonService {
    @Override
    public List<Person> getAll() {
        return List.of(
                new Person("John", "Doe", "john@gmail.com"),
                new Person("Mark", "Doe", "mark@gmail.com"),
                new Person("Clyde", "Doe", "clyde@gmail.com")
        );
    }

    @Override
    public Person getById(int id) {
        return new Person("John " + id, "Doe", "john@gmail.com");
    }

    @Override
    public Person create(Person person) {
        return new Person("John", "Doe", "john@gmail.com");
    }

    @Override
    public Person update(int id, Person person) {
        return new Person("John " + id, "Doe", "john@gmail.com");
    }

    @Override
    public void delete(int id) {

    }
}
