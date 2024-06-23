package br.com.patrick.aplicacaobackend.vo.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

}