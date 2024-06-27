package com.imc.projeto.exception;

import jakarta.persistence.EntityNotFoundException;
import org.hibernate.HibernateError;
import org.hibernate.PropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarerro400(MethodArgumentNotValidException methodArgumentNotValidException) {
        var erros = methodArgumentNotValidException.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(dadosErrosValidacao::new).toList());
    }


    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity tratarErroDeValidacaoHibernate(PropertyValueException propertyValueException) {

        String campo = propertyValueException.getPropertyName();

        // Remove o prefixo até o último ponto para deixar só o nome do campo
        String[] campoPartes = campo.split("\\.");
        String nomeCampoSimplificado = campoPartes[campoPartes.length - 1];

        // Cria uma mensagem de erro personalizada
        String mensagem = String.format("A propriedade '%s' não pode ser nula.", nomeCampoSimplificado);

        // Constrói a instância da record dadosErrosValidacao
        dadosErrosValidacao erro = new dadosErrosValidacao(nomeCampoSimplificado, mensagem);

        return ResponseEntity.badRequest().body(erro);
    }

    private record dadosErrosValidacao(String campo, String mensagem) {

        public dadosErrosValidacao(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

        public dadosErrosValidacao(String campo, String mensagem) {
            this.campo = campo;
            this.mensagem = mensagem;
        }
    }
}