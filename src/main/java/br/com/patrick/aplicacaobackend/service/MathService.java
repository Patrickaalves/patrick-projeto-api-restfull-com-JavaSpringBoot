package br.com.patrick.aplicacaobackend.service;

import br.com.patrick.aplicacaobackend.exceptions.UnsoportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double soma(String numberOne, String numbertwo) {

        // Caso seja passado um valor diferente de numero, exemplo: a,b,c... ira disparar a exception
        if (!isNumeric(numberOne) || !isNumeric(numbertwo)) {
            throw new UnsoportedMathOperationException("Por favor informe um valor numerico");
        }

        Double soma = convertToDouble(numberOne) + convertToDouble(numbertwo);
        return soma;
    }

    private Double convertToDouble(String strValor){
        // checando valores nulos ou vazio
        if(strValor == null || strValor.isEmpty()) return 0.0;

        // BR 10,25 US 10.25, ira ser aceito só o "." o que entrar como "," tera que ser convertido para "."
        String number = strValor.replaceAll(",", ".");

        if(isNumeric(number)) return Double.parseDouble(number);

        return 0.0;
    }

    private boolean isNumeric(String strValor){
        // checando valores nulos ou vazio
        if(strValor == null || strValor.isEmpty()) return false;

        // BR 10,25 US 10.25, ira ser aceito só o "." o que entrar como "," tera que ser convertido para "."
        String number = strValor.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
