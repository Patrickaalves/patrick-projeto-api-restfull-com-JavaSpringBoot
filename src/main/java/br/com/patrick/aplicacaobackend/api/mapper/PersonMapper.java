package br.com.patrick.aplicacaobackend.api.mapper;

import br.com.patrick.aplicacaobackend.api.vo.v1.PersonVO;
import br.com.patrick.aplicacaobackend.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonMapper {
    private final ModelMapper mapper;

    // Recebe um vo, e converte para person
    public Person personVoToPerson(PersonVO personVO) {
        return mapper.map(personVO, Person.class);
    }

    // recebe uma person e converte para vo
    public PersonVO personToPersonVO(Person person) {
        return mapper.map(person, PersonVO.class);
    }

    public List<PersonVO> personToPersonVOList(List<Person> personList) {
        return personList.stream()
                .map(this::personToPersonVO)
                .collect(Collectors.toList());
    }

}
