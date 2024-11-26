package com.alibou.security.security.auth;

import com.alibou.security.util.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.alibou.security.util.entity.BaseEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "register_transection")
public class RegisterTransection extends BaseEntity{
  private String firstname;
  private String lastname;
  private String email;
  private String password;
}
