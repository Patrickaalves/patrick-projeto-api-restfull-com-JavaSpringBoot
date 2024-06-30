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
public class MapperGeneric {

    private static ModelMapper mapper = new ModelMapper();

    static {
        // Fazer um parse de key para id
        mapper.createTypeMap(Person.class, PersonVO.class)
                .addMapping(Person::getId, PersonVO::setKey);

        mapper.createTypeMap(PersonVO.class, Person.class)
                .addMapping(PersonVO::getKey, Person::setId);
    }

    public <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public <O, D> List<D> parseListObject(List<O> origin, Class<D> destination){
        return origin.stream()
                .map(o -> parseObject(o, destination))
                .collect(Collectors.toList());
    }
}
