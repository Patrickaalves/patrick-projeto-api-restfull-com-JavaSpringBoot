package br.com.patrick.aplicacaobackend.services;

import br.com.patrick.aplicacaobackend.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(long id) {

        logger.info("Buscando uma pessoa por id");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Patrick");
        person.setLastName("Alves");
        person.setEndereco("Joinville - Santa catarina - Brasil");
        person.setGender("Masculino");

        return person;
    }
}
