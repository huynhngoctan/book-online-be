package com.nlu.bookonlinebe.services;

import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.models.User;

public interface UserService {
    public ResponseObject getAllUsers();
    public ResponseObject registerNewUser(User newUser);
}
