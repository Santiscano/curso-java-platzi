package com.firstproject.apirest.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Iterable<Person> getPersons() 
    {
        return personRepository.findAll();
    }

    public Person getPerson(long id) 
    {
        return personRepository.findById(id).orElse(null);
    }

    public void createPerson(Person person) 
    {
        personRepository.save(person);
    }

    public void updatePerson(Person person) 
    {
        personRepository.save(person);
    }

    public void deletePerson(long id) 
    {
        personRepository.deleteById(id);
    }
}
