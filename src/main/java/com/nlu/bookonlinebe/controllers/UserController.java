package com.nlu.bookonlinebe.controllers;

import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.models.User;
import com.nlu.bookonlinebe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllUsers(){
        ResponseObject result = userService.getAllUsers();
        return ResponseEntity.status(result.getStatuscode()).body(result);
    }

    @PostMapping
    public ResponseEntity<ResponseObject> registerNewUser(@RequestBody User newUser){
        ResponseObject result = userService.registerNewUser(newUser);
        return ResponseEntity.status(result.getStatuscode()).body(result);
    }
}
