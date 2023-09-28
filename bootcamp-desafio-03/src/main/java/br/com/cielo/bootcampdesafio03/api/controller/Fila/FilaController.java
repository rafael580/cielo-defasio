package br.com.cielo.bootcampdesafio03.api.controller.Fila;

import io.awspring.cloud.sqs.annotation.SqsListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class FilaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilaController.class);
    public static final String QUEUE = "bootcamp-cielo.fifo";

    @SqsListener(QUEUE)
    public void listen(@Payload Object message) {
        LOGGER.info("Received message {} {}", message);
        System.out.println(message);
    }

}
