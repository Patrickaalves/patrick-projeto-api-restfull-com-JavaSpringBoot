package br.com.patrick.aplicacaobackend.controller;

import br.com.patrick.aplicacaobackend.model.Person;
import br.com.patrick.aplicacaobackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person findByIdPerson(@PathVariable long id) {
        Person buscarPerson = personService.findById(id);
        return buscarPerson;
    }
}
