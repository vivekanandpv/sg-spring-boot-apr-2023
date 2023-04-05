package com.vivekanandpv.springbootstarterproject.apis;

import com.vivekanandpv.springbootstarterproject.models.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/persons")
public class PersonsApi {
    @GetMapping
    public ResponseEntity<List<Person>> get() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> get(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }


    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> update(@PathVariable int id, @RequestBody Person person) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Person> delete(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }
}
