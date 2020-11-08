package com.wsm.service;

import com.wsm.entity.User;

public interface UserService {

    User checkUser(String username, String password);
}
