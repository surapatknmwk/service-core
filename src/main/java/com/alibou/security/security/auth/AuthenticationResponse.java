package com.alibou.security.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
  String code;
  String msg;
  // @JsonProperty("access_token")
  // private String accessToken;
  // @JsonProperty("refresh_token")
  // private String refreshToken;
}
