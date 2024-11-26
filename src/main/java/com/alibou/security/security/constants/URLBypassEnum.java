package com.alibou.security.security.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum URLBypassEnum {
    SWG_UI("/swagger-ui"),
    SWG_DOC_API("/v3/api-docs"),
    URL_LOGIN("/api/v1/auth");
    String path;
}
