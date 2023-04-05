package com.vivekanandpv.springbootstarterproject.apis;

import com.vivekanandpv.springbootstarterproject.models.Person;
import com.vivekanandpv.springbootstarterproject.services.PersonService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/persons")
public class PersonsApi {
    private final PersonService service;

    public PersonsApi(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Person>> get() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Person> get(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.ok(service.create(person));
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> update(@PathVariable int id, @RequestBody Person person) {
        return ResponseEntity.ok(service.update(id, person));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Person> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
