package com.alibou.security.module.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class schedule {

    private static final Logger LOGGER = LoggerFactory.getLogger(schedule.class);

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    // @Scheduled(fixedRate = 5000)
    public void simple(){
        LOGGER.info("schedule Task :: Execution Time - {}", dateFormat.format(LocalDateTime.now()));
    }
    
}
