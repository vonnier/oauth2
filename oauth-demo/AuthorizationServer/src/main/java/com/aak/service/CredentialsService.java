package com.aak.service;


import com.aak.entity.Credentials;

public interface CredentialsService {
    Credentials selectByName(String userName);
}
