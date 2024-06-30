package br.com.patrick.aplicacaobackend.api.vo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonPropertyOrder({"id","first_name","last_name","gender","address"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO implements Serializable {

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonIgnore
    private String address;

    private String gender;

}
