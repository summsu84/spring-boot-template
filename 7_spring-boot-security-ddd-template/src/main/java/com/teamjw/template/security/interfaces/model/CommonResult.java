package com.teamjw.template.security.interfaces.model;

import lombok.Getter;
import lombok.Setter;

/**
 *  컨틀롤러에 해당하는 Model 정보
 */
@Getter
@Setter
public class CommonResult {

    private boolean success;

    private int code;

    private String msg;
}

