package com.alibou.security.module.user.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibou.security.util.entity.ResponseModel;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import com.alibou.security.module.schedule.schedule;
import com.alibou.security.module.user.entity.User;
import com.alibou.security.module.user.services.UserService;
import com.alibou.security.security.auth.RegisterRequest;
import com.alibou.security.module.user.entity.UserResponse;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("User API Module");
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        LOGGER.info("UserController :: getAll ");
        List<User> users = userService.getAll();
        List<UserResponse> response = new UserResponse().convertToLists(users);
        LOGGER.info("Response size : {}", response.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        LOGGER.info("UserController :: get Id : {}",id);
       
        LOGGER.info("Response size : {}", 0);
        return ResponseEntity.ok("OK");
    }

    // templete  เฉย จริงๆ ต้องใช้ของ module authen ในการ register
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody RegisterRequest request) {
        LOGGER.info("UserController :: create request : {}",request);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        LOGGER.info("UserController :: delete id : {}",id);
        return ResponseEntity.ok("OK");
    }
    
}
