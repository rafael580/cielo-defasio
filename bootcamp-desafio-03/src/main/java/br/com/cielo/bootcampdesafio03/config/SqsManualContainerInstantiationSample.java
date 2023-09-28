package br.com.cielo.bootcampdesafio03.config;



import br.com.cielo.bootcampdesafio03.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio03.dto.ClienteDTO;
import io.awspring.cloud.sqs.listener.SqsMessageListenerContainer;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.util.UUID;

@Configuration
public class SqsManualContainerInstantiationSample {

    public static final String NEW_USER_QUEUE = "bootcamp-cielo.fifo";

    private static final Logger LOGGER = LoggerFactory.getLogger(SqsManualContainerInstantiationSample.class);

    @Bean
    public ApplicationRunner sendMessageToQueueManualContainerInstantiation(SqsTemplate sqsTemplate) {



        LOGGER.info("Sending message");
        return args -> sqsTemplate.send(to -> to.queue(NEW_USER_QUEUE)
                .payload(new User(UUID.randomUUID(), "John"))
        );
    }

    @Bean
    public SqsTemplate sqsTemplateManualContainerInstantiation(SqsAsyncClient sqsAsyncClient) {
        return SqsTemplate.builder()
                .sqsAsyncClient(sqsAsyncClient)
                .build();
    }

    @Bean
    SqsMessageListenerContainer<User> sqsMessageListenerContainer(SqsAsyncClient sqsAsyncClient) {
        return new SqsMessageListenerContainer.Builder<User>()
                .sqsAsyncClient(sqsAsyncClient)
                .queueNames(NEW_USER_QUEUE)
                .messageListener((message) -> {
                    LOGGER.info("Received message {}", message.getPayload());
                })
                .build();
    }

    public record User(UUID id, String name) {
    }
}