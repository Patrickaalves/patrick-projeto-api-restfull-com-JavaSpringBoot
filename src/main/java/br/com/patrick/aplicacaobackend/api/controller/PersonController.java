package br.com.patrick.aplicacaobackend.api.controller;

import br.com.patrick.aplicacaobackend.api.vo.v2.PersonVOV2;
import br.com.patrick.aplicacaobackend.domain.services.PersonService;
import br.com.patrick.aplicacaobackend.api.vo.v1.PersonVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@Tag(name = "Pessoa", description = "Endpoints para gerenciar pessoas") // https://lankydan.dev/documenting-a-spring-rest-api-following-the-openapi-specification
public class PersonController {

    @Autowired
    private PersonService personService;


    @Operation(summary = "Adicionar uma pessoa", description = "Adicionar uma pessoa",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",content =
                    @Content(schema = @Schema(implementation = PersonVO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @PostMapping(value = "/v1",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> savePerson(@RequestBody PersonVO personVoRequest){

        PersonVO criarPerson = personService.createPerson(personVoRequest);

        return new ResponseEntity<>(criarPerson, HttpStatus.CREATED);
    }


    @PostMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV2> savePersonV2(@RequestBody PersonVOV2 personVoRequest){

        PersonVOV2 criarPerson = personService.createPersonV2(personVoRequest);

        return new ResponseEntity<>(criarPerson, HttpStatus.CREATED);
    }

    @Operation(summary = "Procurar uma pessoa por id", description = "Procurar uma pessoa por id",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",content =
                    @Content(schema = @Schema(implementation = PersonVO.class))),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @GetMapping(value = "/v1/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findByIdPerson(@PathVariable long id) {

        PersonVO buscarPerson = personService.findById(id);
        return buscarPerson;
    }

    @Operation(summary = "Procurar por todas as pessoas", description = "Procurar por todas as pessoas",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    mediaType = "Application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
                            )),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @GetMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public List<PersonVO> findAllPersons() {
        return personService.findAll();
    }

    @Operation(summary = "Atualizar uma pessoa", description = "Atualizar uma pessoa",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",content =
                    @Content(schema = @Schema(implementation = PersonVO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @PutMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO updatePerson(@RequestBody PersonVO person){
        return personService.updatePerson(person);
    }

    @Operation(summary = "Deletando uma pessoa", description = "Deletando uma pessoa",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "No content", responseCode = "204",content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable long id){
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.NO_CONTENT);
    }

}
