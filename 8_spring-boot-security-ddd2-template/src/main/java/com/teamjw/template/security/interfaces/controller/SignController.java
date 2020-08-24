package com.teamjw.template.security.interfaces.controller;


import com.teamjw.template.security.domain.User;
import com.teamjw.template.security.infrastructure.config.security.JwtTokenProvider;
import com.teamjw.template.security.exception.CEmailSigninFailedException;
import com.teamjw.template.security.interfaces.model.CommonResult;
import com.teamjw.template.security.interfaces.model.SingleResult;
import com.teamjw.template.security.repo.UserJpaRepo;
import com.teamjw.template.security.application.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserJpaRepo userJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;
    // login
    @PostMapping(value = "/signin")
    public SingleResult<String> signin(@RequestParam String id,
                                       @RequestParam String password) {

        User user = userJpaRepo.findByUid(id).orElseThrow(CEmailSigninFailedException::new);
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new CEmailSigninFailedException();

        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getId()), user.getRoles()));
    }

    // singup
    @PostMapping(value = "/signup")
    public CommonResult signup(@RequestParam String id,
                               @RequestParam String password,
                               @RequestParam String name) {

        userJpaRepo.save(User.builder()
                .uid(id)
                .password(passwordEncoder.encode(password))
                .username(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        return responseService.getSuccessResult();
    }
}
