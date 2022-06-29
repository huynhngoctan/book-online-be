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
        List<User> users= userRepo.findAll();
        return new ResponseObject("success","Get all user success",users);
    }

    @Override
    public ResponseObject registerNewUser(User newUser) {
        Optional<User> user = userRepo.findByUsername(newUser.getUsername());
        if(user.isPresent()){
            return new ResponseObject("failed","Username is exist",null);
        }else {
            User saveUser = userRepo.save(newUser);
            return new ResponseObject("success","Register new user is successfull",saveUser);
        }
    }

    @Override
    public ResponseObject deleteUser(long id) {
        boolean isExist = userRepo.existsById(id);
        if(isExist) {
            userRepo.deleteById(id);
            return new ResponseObject("success","Delete user successfull","");
        }else{
            return new ResponseObject("failed","Id is not exist","");
        }
    }

}
