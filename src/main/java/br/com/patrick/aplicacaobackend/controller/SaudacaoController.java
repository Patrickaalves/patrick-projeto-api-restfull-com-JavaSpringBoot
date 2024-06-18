package br.com.patrick.aplicacaobackend.controller;

import br.com.patrick.aplicacaobackend.entity.Saudacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/saudacao")
public class SaudacaoController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Saudacao saudacao(@RequestParam(value = "name", defaultValue = "Nome padrão") String nome){

        Saudacao saudacao = new Saudacao(counter.incrementAndGet(), String.format(template, nome));

        return saudacao;
    }
}
