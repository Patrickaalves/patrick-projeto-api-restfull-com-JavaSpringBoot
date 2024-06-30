package br.com.patrick.aplicacaobackend.domain.services;

import br.com.patrick.aplicacaobackend.api.controller.PersonController;
import br.com.patrick.aplicacaobackend.api.mapper.MapperGeneric;
import br.com.patrick.aplicacaobackend.api.mapper.PersonMapper;
import br.com.patrick.aplicacaobackend.api.mapper.PersonMapperCustom;

import br.com.patrick.aplicacaobackend.api.vo.v1.PersonVO;
import br.com.patrick.aplicacaobackend.api.vo.v2.PersonVOV2;
import br.com.patrick.aplicacaobackend.domain.model.Person;
import br.com.patrick.aplicacaobackend.domain.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
    @Autowired
    PersonMapperCustom personMapperCustom;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonVO createPerson(PersonVO personVo) {
        logger.info("Criando uma pessoa");
        /*
        * Recebo meu VO, e converto ele para minha person,
        * Agora que tenho minha person, posso chamar meu repository e salvar no banco
        * E devolvo o VO
        * */
        Person person = personRepository.save(personMapper.personVoToPerson(personVo));

        PersonVO vo = mapperGeneric.parseObject(person, PersonVO.class);

        vo.add(linkTo(methodOn(PersonController.class).findByIdPerson(vo.getKey())).withSelfRel());

        return vo;
    }

    public PersonVOV2 createPersonV2(PersonVOV2 personVoV2) {
        logger.info("Criando uma pessoa v2");

        var entity = personMapperCustom.convertVoToEntity(personVoV2);

        var vo = personMapperCustom.convertEntityToVo(personRepository.save(entity));

        return vo;
    }

    public PersonVO findById(long id) {
        logger.info("Buscando uma pessoa por id");

        Person personFindById = personRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Erro ao buscar uma pessoa com o id: " + id)
        );

        PersonVO vo = mapperGeneric.parseObject(personFindById, PersonVO.class);

        vo.add(linkTo(methodOn(PersonController.class).findByIdPerson(id)).withSelfRel());
        return vo;

    }

    public List<PersonVO> findAll() {
        logger.info("Buscando todas as persons");

        List<Person> persons = personRepository.findAll();

        List<PersonVO> vo = mapperGeneric.parseListObject(persons, PersonVO.class);

        vo.stream()
                .forEach(p -> p.add(linkTo(methodOn(PersonController.class).findByIdPerson(p.getKey())).withSelfRel()));

        return vo;
    }

    public PersonVO updatePerson(PersonVO person) {
        logger.info("Atualizando uma pessoa");

        Person attPerson = personRepository.findById(person.getKey()).orElseThrow(
                () -> new ResolutionException("Erro ao buscar uma pessoa com o id: " + person.getKey())
        );

        attPerson.setFirstName(person.getFirstName());
        attPerson.setLastName(person.getLastName());
        attPerson.setAddress(person.getAddress());
        attPerson.setGender(person.getGender());

        personRepository.save(attPerson);

        PersonVO vo = mapperGeneric.parseObject(attPerson, PersonVO.class);

        vo.add(linkTo(methodOn(PersonController.class).findByIdPerson(vo.getKey())).withSelfRel());
        return vo;
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
