package com.shop.user.repo;

import com.shop.user.Model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String>{
    
}
