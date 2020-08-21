package com.teamjw.template.security.infrastructure.config.util.i18n;

public class I18nCode {
    public final String code;
    public final Object[] args;

    public I18nCode(String code, Object... args) {
        this.code = code;
        this.args = args;
    }
}
