package com.vainglory.service;


/*
登录的接口
password|sms|social|xcx|email
 */

import com.vainglory.domain.Client;
import com.vainglory.domain.R;
import com.vainglory.domain.User;

public interface ILoginValidService {
  R<User> login(String body, Client client);
}
