package br.com.patrick.aplicacaobackend.api.controller;

import br.com.patrick.aplicacaobackend.api.vo.v2.PersonVOV2;
import br.com.patrick.aplicacaobackend.domain.services.PersonService;
import br.com.patrick.aplicacaobackend.api.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping(value = "/v1",produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> savePerson(@RequestBody PersonVO personVoRequest){

        PersonVO criarPerson = personService.createPerson(personVoRequest);

        return new ResponseEntity<>(criarPerson, HttpStatus.CREATED);
    }


    @PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV2> savePersonV2(@RequestBody PersonVOV2 personVoRequest){

        PersonVOV2 criarPerson = personService.createPersonV2(personVoRequest);

        return new ResponseEntity<>(criarPerson, HttpStatus.CREATED);
    }

    @GetMapping(value = "/v1/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findByIdPerson(@PathVariable long id) {

        PersonVO buscarPerson = personService.findById(id);
        return buscarPerson;
    }


    @GetMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAllPersons() {
        return personService.findAll();
    }

    @PutMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO updatePerson(@RequestBody PersonVO person){
        return personService.updatePerson(person);
    }

    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable long id){
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.NO_CONTENT);
    }

}