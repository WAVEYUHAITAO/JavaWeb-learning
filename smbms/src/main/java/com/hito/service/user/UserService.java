package com.hito.service.user;

import com.hito.pojo.User;

public interface UserService {
    public User login(String userCode,String password);
}
