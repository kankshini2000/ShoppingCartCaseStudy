package com.shop.user.control;

import java.util.List;
import java.util.Optional;

import com.shop.user.Model.User;
import com.shop.user.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserControl {
    

    @Autowired
    private UserRepo repo;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User user){
        repo.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<User> getUser(){
        return repo.findAll();
    }

    @GetMapping("/all/{userName}")
    public Optional<User> getUserbyName(@PathVariable String userName){
        return repo.findById(userName);
    }

    @PutMapping("/update/{userName}")
    public ResponseEntity<String> update(@PathVariable String userName,@RequestBody User user){
        repo.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/del/{userName}")
    public String DelUserbyName(@PathVariable String userName){
        repo.findById(userName);
        return "User deleted with name" +userName;
    }
}
