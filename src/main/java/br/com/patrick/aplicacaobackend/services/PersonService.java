package br.com.patrick.aplicacaobackend.services;

import br.com.patrick.aplicacaobackend.model.Person;
import br.com.patrick.aplicacaobackend.repository.PersonRepository;
import br.com.patrick.aplicacaobackend.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person createPerson(PersonVO person) {
        logger.info("Criando uma pessoa");

        Person criarPerson = personRepository.save(person);

        return criarPerson;
    }

    public Person findById(long id) {
        logger.info("Buscando uma pessoa por id");

        Person personFindById = personRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Erro ao buscar uma pessoa com o id: " + id)
        );

        return personFindById;
    }

    public List<Person> findAll() {
        logger.info("Buscando todas as persons");

        List<Person> persons = personRepository.findAll();

        return persons;
    }

    public Person updatePerson(PersonVO person) {
        logger.info("Atualizando uma pessoa");

        Person attPerson = personRepository.findById(person.getId()).orElseThrow(
                () -> new ResolutionException("Erro ao buscar uma pessoa com o id: " + person.getId())
        );

        attPerson.setFirstName(person.getFirstName());
        attPerson.setLastName(person.getLastName());
        attPerson.setAddress(person.getAddress());
        attPerson.setGender(person.getGender());

        personRepository.save(attPerson);

        return attPerson;
    }

    public String deletePerson(long id) {
        logger.info("Deletando uma pessoa");

        personRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Erro ao buscar uma pessoa com o id: " + id)
        );

        personRepository.deleteById(id);

        return "Pessoa ligada ao id " + id + " foi excluida com sucesso";
    }
}
