package com.vainglory.system.service;

import com.vainglory.common.core.domain.R;
import com.vainglory.system.domain.Client;
import com.vainglory.system.domain.User;

/*
登录的接口
password|sms|social|xcx|email
 */

public interface ILoginValidService {
  String LOGIN_VALID_SERVICE = "LoginValidService";
  R<User> login(String body, Client client);
}
