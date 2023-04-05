package com.vivekanandpv.springbootstarterproject.services;

import com.vivekanandpv.springbootstarterproject.config.AppConfig;
import com.vivekanandpv.springbootstarterproject.models.Person;
import com.vivekanandpv.springbootstarterproject.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImplementation implements PersonService {
    private final AppConfig config;
    private final PersonRepository repository;

    public PersonServiceImplementation(AppConfig config, PersonRepository repository) {
        this.config = config;
        this.repository = repository;
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public Person getById(int id) {
//        Optional<Person> optional = repository.findById(id);
//
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            throw new RuntimeException("could not find");
//        }

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the record"));
    }

    @Override
    public Person create(Person person) {
        repository.saveAndFlush(person);
        return person;
    }

    @Override
    public Person update(int id, Person person) {
        Person personDb = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the record"));

        personDb.setFirstName(person.getFirstName());
        personDb.setLastName(person.getLastName());
        personDb.setEmail(person.getEmail());

        repository.saveAndFlush(personDb);
        return person;
    }

    @Override
    public void delete(int id) {
        Person personDb = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the record"));

        repository.delete(personDb);
    }
}
