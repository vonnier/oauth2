package com.aak.service.impl;


import com.aak.dao.CredentialsMapper;
import com.aak.entity.Credentials;
import com.aak.entity.CredentialsExample;
import com.aak.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentailsServiceImpl implements CredentialsService {
    @Autowired
    private CredentialsMapper credentialsMapper;

    @Override
    public Credentials selectByName(String userName){
        CredentialsExample example = new CredentialsExample();
        example.createCriteria().andNameEqualTo(userName);
        List<Credentials> userList = credentialsMapper.selectByExample(example);
        if (userList == null || userList.size() < 1) {
            return null;
        }
        return userList.get(0);
    }
}
