package br.com.patrick.aplicacaobackend.services;

import br.com.patrick.aplicacaobackend.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Person> findAll() {

        logger.info("Buscando todas as persons");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person createPerson(Person person) {
        return null;
    }

    public Person mockPerson(int id) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Patrick " + id);
        person.setLastName("Alves");
        person.setEndereco("Joinville - Santa catarina - Brasil");
        person.setGender("Masculino");

        return person;
    }
}
