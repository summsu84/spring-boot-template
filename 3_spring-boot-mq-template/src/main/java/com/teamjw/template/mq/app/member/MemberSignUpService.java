package com.teamjw.template.mq.app.member;

import com.teamjw.template.mq.app.event.SignUpedEvent;
import com.teamjw.template.mq.app.rabbitmq.RabbitMqEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor    // Constructur Injection
public class MemberSignUpService {

    private final MemberRepository memberRepository;
    // Bean 으로 등록된 amqpTemplate 를 가져온다.
    private final AmqpTemplate amqpTemplate;


    public Member doSignUp(final SignUpRequest dto) {
        final Member member = memberRepository.save(dto.toEntity());

        // Message Producer
        //
        amqpTemplate.convertAndSend(RabbitMqEvent.MEMBER_SIGNUPED_EVENT, SignUpedEvent.of(member));

        return member;
    }


}