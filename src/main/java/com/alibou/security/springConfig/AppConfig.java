package com.alibou.security.springConfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(ignoreResourceNotFound=true,value="classpath:application.yml")
@Getter
public class AppConfig {
    
    @Value("${app-version}")
    private String appVersion;
}
