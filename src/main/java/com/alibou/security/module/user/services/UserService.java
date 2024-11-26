package com.alibou.security.module.user.services;

import java.util.List;
import com.alibou.security.module.user.entity.User;

public interface UserService {
    List<User> getAll();
}
