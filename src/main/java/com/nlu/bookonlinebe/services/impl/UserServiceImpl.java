package com.nlu.bookonlinebe.services.impl;

import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.models.User;
import com.nlu.bookonlinebe.repositories.UserRepository;
import com.nlu.bookonlinebe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Override
    public ResponseObject getAllUsers() {
        List<User> users = userRepo.findAll();
        return new ResponseObject("success", "Get all user success", users);
    }

    @Override
    public ResponseObject getUser(long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return new ResponseObject("success", "Get user successfull", user);
        } else {
            return new ResponseObject("failed", "User does not exist", "");
        }
    }

    @Override
    public ResponseObject registerNewUser(User newUser) {
        Optional<User> user = userRepo.findByUsername(newUser.getUsername());
        if (user.isPresent()) {
            return new ResponseObject("failed", "Username is exist", null);
        } else {
            User saveUser = userRepo.save(newUser);
            return new ResponseObject("success", "Register new user is successfull", saveUser);
        }
    }

    @Override
    public ResponseObject updateUser(long id, User newUser) {
        Optional<User> userOptional = userRepo.findById(id);
        if (!userOptional.isPresent()) return new ResponseObject("failed", "User does not exist", null);
        User updatedUser = (User) userOptional.map(user -> {
                    user.setFullname(newUser.getFullname());
                    user.setAddress(newUser.getAddress());
                    user.setEmail(newUser.getEmail());
                    user.setRole(newUser.getRole());
                    user.setStatus(newUser.getStatus());
                    user.setAvatar(newUser.getAvatar());
                    user.setPhone(newUser.getPhone());
                    return userRepo.save(user);
                }
        ).orElseGet(null);
        if (updatedUser == null) return new ResponseObject("failed", "Update unsuccessfull", null);
        else return new ResponseObject("success", "Update successfull", updatedUser);
    }


    @Override
    public ResponseObject deleteUser(long id) {
        boolean isExist = userRepo.existsById(id);
        if (isExist) {
            userRepo.deleteById(id);
            return new ResponseObject("success", "Delete user successfull", "");
        } else {
            return new ResponseObject("failed", "Id is not exist", "");
        }
    }

    @Override
    public ResponseObject findUsername(String username) {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isPresent()) {
            return new ResponseObject("success", "Username is exist", "");
        } else {
            return new ResponseObject("failed", "Username is not exist", "");
        }
    }

    @Override
    public ResponseObject searchByUsername(String username) {
        List<User> users = userRepo.findByUsernameContainingIgnoreCase(username);
        return new ResponseObject("success", "Search completed", users);
    }

    @Override
    public ResponseObject checkIfExisted(String email, String password) {
        User user = userRepo.findUserByEmailAndPassword(email, password);
        if (user == null) {
            return new ResponseObject("success", "Search completed", "false");
        }
        else {
            user.setPassword(null);
            return new ResponseObject("success", "Search completed", user);
        }
    }

    @Override
    public ResponseObject checkEmail(String email) {
        User user = userRepo.findUserByEmail(email);
        if (user != null){
            return new ResponseObject("success", "Search completed", "true");
        }
        else {
            return new ResponseObject("success", "Search completed", "false");
        }
    }

    @Override
    public ResponseObject loginAdmin(String username, String password) {
        Optional<User> userOptional = userRepo.findByUsernameAndPassword(username, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (!user.getRole().equals("admin"))
                return new ResponseObject("failed", "Role", "");
            if (!user.getStatus().equals("Kích hoạt"))
                return new ResponseObject("failed", "Status", "");
            return new ResponseObject("success", "Login successfull", user);

        } else {
            return new ResponseObject("failed", "Wrong", "");
        }
    }

}
