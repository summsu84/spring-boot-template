package com.teamjw.template.mq.app.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {

    private final int MAX_TRY_COUNT = 3;
    private final int INITIAL_INTERVAL = 3000;
    private final int MULTIPLIER = 3;
    private final int MAX_INTERVAL = 10000;

    private final ConnectionFactory connectionFactory;

    // 지정된 이름으로 큐를 등록한다.
    // 서로 다른 이름으로 여러개의 Queue를 등록 할 수 있음
    @Bean
    public Queue memberSignUped() {
        return QueueBuilder
                .durable(RabbitMqEvent.MEMBER_SIGNUPED_EVENT)
                .build();
    }

    // Exchange
    // Exchange 설정. 주어진 패턴과 일치하는 Queue에 메시지 전달.
    // Exchange는 Direct, Fanout, Topic, Headers 가 존재

    // Binding
    // Exchange 가 Queue에게 메시지를 전달하기 위한 룰
    // 빈으로 등록된 Queue와 Exchange를 바인딩하면서 Exchange 에서 사용될 패턴을 설정


    // 이벤트를 Publishing

    // RabbitTemplate
    // Spring에서 자동으로 빈 등록을 해주지만, 받은 메시지 처리를 위한 메시지 컨버터를 설정하기 위한 오버라이딩.
    @Bean
    public RabbitTemplate amqpTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setChannelTransacted(true);
        rabbitTemplate.setReplyTimeout(60000);
        rabbitTemplate.setMessageConverter(queueMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory) {
        final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setDefaultRequeueRejected(false);
        factory.setMessageConverter(queueMessageConverter());
        factory.setChannelTransacted(true);
        factory.setAdviceChain(RetryInterceptorBuilder
                .stateless()
                .maxAttempts(MAX_TRY_COUNT)
                .recoverer(new RabbitMqExceptionHandler())
                .backOffOptions(INITIAL_INTERVAL, MULTIPLIER, MAX_INTERVAL)
                .build());
        return factory;
    }

    private Jackson2JsonMessageConverter queueMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }



}