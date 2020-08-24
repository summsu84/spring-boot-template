package com.teamjw.template.security.interfaces.model;


import com.teamjw.template.security.infrastructure.config.util.i18n.I18nMessage;
import lombok.Data;

import java.util.Set;

@Data
public class ErrorResponse {
    private Set<I18nMessage> errors;
}
