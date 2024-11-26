package com.alibou.security.security.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum authenEnum {
    HEADER_PARAMETER("Authorization"),
    PREFIX_TOKEN("Bearer ");
    String value;
}
