package br.com.patrick.aplicacaobackend.exceptions.handler;

import br.com.patrick.aplicacaobackend.exceptions.ExceptionResponse;
import br.com.patrick.aplicacaobackend.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // As exceções mais genericas do java são exception handler, junto com a internal_server_error
    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ExceptionResponse> HandleAllExceptions(Exception ex,
                                                                       WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                                                                    ex.getMessage(),
                                                                    request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // No rest a exceção mais generica é a internal server error
    @ExceptionHandler({ResourceNotFoundException.class})
    public final ResponseEntity<ExceptionResponse> HandleNotFoundExceptions(Exception ex,
                                                                       WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                                                                    ex.getMessage(),
                                                                    request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}
