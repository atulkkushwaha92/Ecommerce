package com.nagp.ecommerce.authenticationservice.service;

import com.nagp.ecommerce.authenticationservice.entity.UserInfo;

import java.security.NoSuchAlgorithmException;

public interface AuthDataService {

    UserInfo findByUsername(String username);

    UserInfo findByEmail(String email);

    void deleteByUsernamePassword(String username, String password) throws NoSuchAlgorithmException;

    void createUserProfile(UserInfo userInfo) throws NoSuchAlgorithmException;
}
