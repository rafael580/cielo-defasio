package br.com.cielo.bootcampdesafio03.config;

import br.com.cielo.bootcampdesafio03.dto.ClienteDTO;
import io.awspring.cloud.sqs.listener.SqsMessageListenerContainer;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class SqsManualContainerInstantiationSample {

    public static final String NEW_USER_QUEUE = "bootcamp";

    private static final Logger LOGGER = LoggerFactory.getLogger(SqsManualContainerInstantiationSample.class);

    @Bean
    public ApplicationRunner sendMessageToQueueManualContainerInstantiation(SqsTemplate sqsTemplate) {
        LOGGER.info("Sending message");
        return args -> sqsTemplate.send(to -> to.queue(NEW_USER_QUEUE)
                .payload(new ClienteDTO(1l,"23412444422","0003","rafael","rafael@gmail.com"))
        );
    }

    @Bean
    public SqsTemplate sqsTemplateManualContainerInstantiation(SqsAsyncClient sqsAsyncClient) {
        return SqsTemplate.builder()
                .sqsAsyncClient(sqsAsyncClient)
                .build();
    }

    @Bean
    SqsMessageListenerContainer<ClienteDTO> sqsMessageListenerContainer(SqsAsyncClient sqsAsyncClient) {
        return new SqsMessageListenerContainer.Builder<ClienteDTO>()
                .sqsAsyncClient(sqsAsyncClient)
                .queueNames(NEW_USER_QUEUE)
                .messageListener((message) -> {
                    LOGGER.info("Received message {}", message);
                })
                .build();
    }
}