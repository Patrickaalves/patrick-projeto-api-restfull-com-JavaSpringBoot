package br.com.patrick.aplicacaobackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private String endereco;
    private String gender;

}
