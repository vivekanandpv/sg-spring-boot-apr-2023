package com.vivekanandpv.springbootstarterproject.apis;

import com.vivekanandpv.springbootstarterproject.models.Person;
import com.vivekanandpv.springbootstarterproject.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/persons")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})

@Api(tags = {"Persons API"})
public class PersonsApi {
    private final PersonService service;

    public PersonsApi(PersonService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Get all persons")
    public ResponseEntity<List<Person>> get() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Person> get(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }


    @PostMapping
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
