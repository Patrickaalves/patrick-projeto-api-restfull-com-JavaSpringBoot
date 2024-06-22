package br.com.patrick.aplicacaobackend.controller;

import br.com.patrick.aplicacaobackend.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    MathService mathService;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/sum/{numberOne}/{numbertwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numbertwo) throws Exception {

        return mathService.soma(numberOne, numbertwo);
    }

    @GetMapping("/sub/{numberOne}/{numbertwo}")
    public Double subtraction (@PathVariable String numberOne,
                               @PathVariable String numbertwo){
        return mathService.subtracao(numberOne, numbertwo);
    }

    @GetMapping("/mul/{numberOne}/{numbertwo}")
    public Double multiplication (@PathVariable String numberOne,
                               @PathVariable String numbertwo){
        return mathService.multiplicacao(numberOne, numbertwo);
    }

    @GetMapping("/div/{numberOne}/{numbertwo}")
    public Double division (@PathVariable String numberOne,
                               @PathVariable String numbertwo){
        return mathService.divisao(numberOne, numbertwo);
    }

    @GetMapping("/sqrt/{numberOne}")
    public Double squareRoot(@PathVariable String numberOne){
        return mathService.raizQuadrada(numberOne);
    }

}
