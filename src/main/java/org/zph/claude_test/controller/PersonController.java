package org.zph.claude_test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zph.claude_test.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final List<Person> persons = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @GetMapping
    public List<Person> getAllPersons() {
        return persons;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return persons.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        Person created = new Person(
                idCounter.getAndIncrement(),
                person.firstName(),
                person.lastName(),
                person.email(),
                person.phoneNumber(),
                person.address(),
                person.city(),
                person.state(),
                person.zipCode(),
                person.country()
        );
        persons.add(created);
        return created;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).id().equals(id)) {
                Person updated = new Person(
                        id,
                        person.firstName(),
                        person.lastName(),
                        person.email(),
                        person.phoneNumber(),
                        person.address(),
                        person.city(),
                        person.state(),
                        person.zipCode(),
                        person.country()
                );
                persons.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean removed = persons.removeIf(p -> p.id().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
