package com.teamjw.template.mq.app.event;

import com.teamjw.template.mq.app.rabbitmq.RabbitMqEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SignUpListener {

    // Message Listener
    // Queue 이름을 기반으로 메시지를 받는 Listener
    @RabbitListener(queues = RabbitMqEvent.MEMBER_SIGNUPED_EVENT)
    public void handleSignUpEvent(final SignUpedEvent event) {
        log.error(event.toString());
        throw new IllegalArgumentException();
    }

}