package com.teamjw.template.security.controller;


import com.teamjw.template.security.config.security.JwtTokenProvider;
import com.teamjw.template.security.entity.User;
import com.teamjw.template.security.exception.CEmailSigninFailedException;
import com.teamjw.template.security.repo.UserJpaRepo;
import com.teamjw.template.security.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

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

        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getMsrl()), user.getRoles()));
    }

    // singup
    @PostMapping(value = "/signup")
    public CommonResult signup(@RequestParam String id,
                               @RequestParam String password,
                               @RequestParam String name) {

        userJpaRepo.save(User.builder()
                .uid(id)
                .password(passwordEncoder.encode(password))
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        return responseService.getSuccessResult();
    }
}
