package br.com.cielo.bootcampdesafio03.api.controller.Fila;

import io.awspring.cloud.sqs.annotation.SqsListener;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fila")
public class FilaController {

    public static final String QUEUE = "bootcamp";

    @SqsListener(QUEUE)
    @GetMapping
    public ResponseEntity<Object> firstElementRow(@Payload Object object){
        return ResponseEntity.ok().body(object);
    }


}
