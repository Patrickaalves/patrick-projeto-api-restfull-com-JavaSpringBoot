package br.com.patrick.aplicacaobackend.api.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({"id","firstName","lastName","address","gender"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    @JsonProperty("id")
    private Long key;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

}
