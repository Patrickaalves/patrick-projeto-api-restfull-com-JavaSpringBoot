package br.com.patrick.aplicacaobackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsoportedMathOperationException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;
}
