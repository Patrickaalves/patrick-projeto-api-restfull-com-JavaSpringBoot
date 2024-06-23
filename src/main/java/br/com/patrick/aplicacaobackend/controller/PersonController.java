package br.com.patrick.aplicacaobackend.controller;

import br.com.patrick.aplicacaobackend.services.PersonService;
import br.com.patrick.aplicacaobackend.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> savePerson(@RequestBody PersonVO person){
        PersonVO criarPerson = personService.createPerson(person);

        return new ResponseEntity<>(criarPerson, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findByIdPerson(@PathVariable long id) {
        PersonVO buscarPerson = personService.findById(id);
        return buscarPerson;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAllPersons() {
        return personService.findAll();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO updatePerson(@RequestBody PersonVO person){
        return personService.updatePerson(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable long id){
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.NO_CONTENT);
    }

}
