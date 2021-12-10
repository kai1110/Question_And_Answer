package com.example.domain.user.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.impl.UserDetailsImpl;
import com.example.repository.UserRepository;

/**
 * ユーザー情報を取得するクラス. また、ユーザー情報の取得と合わせて、認証処理を行います。
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * User(Entity)クラスのリポジトリクラス.
     */
    @Autowired
    private UserRepository repository;

    /**
     * コンストラクタ.
     *
     * @param repository UserRepository
     */
    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * ユーザーIDに紐づくユーザーの詳細情報を取得する.
     *
     * @param userId ユーザーID
     * @return ユーザーの詳細情報
     */
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        // ユーザーIDが空か判定
        if (StringUtils.isEmpty(userId)) {
            // 空の場合、UsernameNotFoundExceptionをthrowする
            throw new UsernameNotFoundException("UserId is empty");
        }

        // ユーザーIDに紐づく情報を取得
        MUser loginUser = repository.findByUserId(userId);

        if (loginUser == null) {
            // ユーザー情報が空の場合、UsernameNotFoundExceptionをthrowする
            throw new UsernameNotFoundException("Not found Username : " + userId);
        }

        // 権限情報
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();



        UserDetailsImpl user = new UserDetailsImpl(loginUser, authorities);

        return user;
    }
}
