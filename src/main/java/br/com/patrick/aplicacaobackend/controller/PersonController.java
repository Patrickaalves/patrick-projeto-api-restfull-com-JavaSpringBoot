package br.com.patrick.aplicacaobackend.controller;

import br.com.patrick.aplicacaobackend.model.Person;
import br.com.patrick.aplicacaobackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        Person criarPerson = personService.createPerson(person);

        return new ResponseEntity<>(criarPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Person findByIdPerson(@PathVariable long id) {
        Person buscarPerson = personService.findById(id);
        return buscarPerson;
    }

    @GetMapping
    public List<Person> findAllPersons() {
        return personService.findAll();
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable long id){
        return personService.deletePerson(id);
    }

}
