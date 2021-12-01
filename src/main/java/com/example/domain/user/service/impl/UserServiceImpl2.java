package com.example.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.repository.UserRepository;

@Service
@Primary
public class UserServiceImpl2 implements UserService {

    @Autowired
    private UserRepository repository;

    /** ユーザー登録 */
    @Transactional
    @Override
    public void signup(MUser user) {

        // 存在チェック
        boolean exists = repository.existsById(user.getUserId());
        if(exists) {
            throw new DataAccessException("ユーザーが既に存在"){};
        }


        // insert
        repository.save(user);
    }
}