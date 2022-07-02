package com.nlu.bookonlinebe.services;

import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.models.User;

public interface UserService {
    public ResponseObject getAllUsers();
    public ResponseObject getUser(long id);
    public ResponseObject registerNewUser(User newUser);
    public ResponseObject updateUser(long id, User newUser);
    public ResponseObject deleteUser(long id);
    public ResponseObject findUsername(String username);
}
