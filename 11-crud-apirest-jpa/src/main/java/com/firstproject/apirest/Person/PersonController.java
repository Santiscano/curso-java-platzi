package com.firstproject.apirest.Person;
package com.firstproject.apirest.PersonService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/")
    public Iterable<Person> getAllPersons() {
        return personService.getPersons();
    }
    
    @GetMapping("/{id}")
    public Person getPerson(@RequestParam long id) {
        return personService.getPerson(id);
    }

    @PostMapping("/")
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }
    
    @PutMapping("/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable long id) {
        personService.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@RequestParam long id) {
        personService.deletePerson(id);
    }
}
