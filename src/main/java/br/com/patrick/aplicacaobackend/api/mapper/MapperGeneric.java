package br.com.patrick.aplicacaobackend.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperGeneric {

    private final ModelMapper mapper;

    public <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public <O, D> List<D> parseListObject(List<O> origin, Class<D> destination){
        return origin.stream()
                .map(o -> parseObject(o, destination))
                .collect(Collectors.toList());
    }
}
