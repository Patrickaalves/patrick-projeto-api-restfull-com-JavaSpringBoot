package br.com.patrick.aplicacaobackend.domain.services;

import br.com.patrick.aplicacaobackend.api.mapper.MapperGeneric;
import br.com.patrick.aplicacaobackend.api.mapper.PersonMapper;
import br.com.patrick.aplicacaobackend.api.vo.v2.PersonVOV2;
import br.com.patrick.aplicacaobackend.domain.model.Person;
import br.com.patrick.aplicacaobackend.domain.repository.PersonRepository;
import br.com.patrick.aplicacaobackend.api.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    MapperGeneric mapperGeneric;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonVO createPerson(PersonVO personVo) {
        logger.info("Criando uma pessoa");
        /*
        * Recebo meu VO, e converto ele para minha person,
        * Agora que tenho minha person, posso chamar meu repository e salvar no banco
        * E devolvo o VO
        * */
        Person person = personRepository.save(personMapper.personVoToPerson(personVo));

        return mapperGeneric.parseObject(person, PersonVO.class);
    }



    public PersonVO findById(long id) {
        logger.info("Buscando uma pessoa por id");

        Person personFindById = personRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Erro ao buscar uma pessoa com o id: " + id)
        );

        return mapperGeneric.parseObject(personFindById, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Buscando todas as persons");

        List<Person> persons = personRepository.findAll();

        return mapperGeneric.parseListObject(persons, PersonVO.class);
    }

    public PersonVO updatePerson(PersonVO person) {
        logger.info("Atualizando uma pessoa");

        Person attPerson = personRepository.findById(person.getId()).orElseThrow(
                () -> new ResolutionException("Erro ao buscar uma pessoa com o id: " + person.getId())
        );

        attPerson.setFirstName(person.getFirstName());
        attPerson.setLastName(person.getLastName());
        attPerson.setAddress(person.getAddress());
        attPerson.setGender(person.getGender());

        personRepository.save(attPerson);

        return mapperGeneric.parseObject(attPerson, PersonVO.class);
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
