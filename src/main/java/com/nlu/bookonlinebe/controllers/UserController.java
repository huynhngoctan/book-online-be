package com.nlu.bookonlinebe.controllers;

import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.models.User;
import com.nlu.bookonlinebe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserService userService;
//hello
    @GetMapping
    public ResponseEntity<ResponseObject> getAllUsers() {
        ResponseObject result = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getUser(@PathVariable(name = "id") long id) {
        ResponseObject result = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/findUsername")
    public ResponseEntity<ResponseObject> findUsername(@RequestParam String username) {
        ResponseObject result = userService.findUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseObject> searchByUsername(@RequestParam("q") String q){
        ResponseObject result = userService.searchByUsername(q);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<ResponseObject> registerNewUser(@RequestBody User newUser) {
        ResponseObject result = userService.registerNewUser(newUser);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> registerNewUser(
            @PathVariable(name = "id") long id,
            @RequestBody User newUser
    ) {
        ResponseObject result = userService.updateUser(id,newUser);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteUser(@PathVariable(name = "id") long id) {
        ResponseObject result = userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/login")
    public ResponseEntity<ResponseObject> checkIfExisted(@RequestParam String email, @RequestParam String password){
        ResponseObject result = userService.checkIfExisted(email, password);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/checkEmail")
    public ResponseEntity<ResponseObject> checkEmail(@RequestParam String email){
        ResponseObject result = userService.checkEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/loginAdmin")
    public ResponseEntity<ResponseObject> loginAdmin(@RequestParam String username, @RequestParam String password){
        ResponseObject result = userService.loginAdmin(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
