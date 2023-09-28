package br.com.cielo.bootcampdesafio03.api;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fila")
public class FilaController {


    public static final String QUEUE = "bootcamp";

    @SqsListener(QUEUE)
    @GetMapping(value = "/primeiro-da-fila-cliente")
    public ResponseEntity<Object> firstElementRow(Object message){
        return ResponseEntity.ok().body(message);
    }



}
