package com.vainglory.constant;

import org.springframework.http.HttpStatus;

public interface Constants {
  Integer STATUS_ENABLE = 1;
  Integer STATUS_DISABLE = 0;

  Integer HTTP_SUCCESS = 0;
  Integer HTTP_FAILED = HttpStatus.INTERNAL_SERVER_ERROR.value();

  String KEY_CLIENT = "clientId";
  String KEY_USER = "userId";
  String KEY_TENANT = "tenantId";

  Integer MENU_TYPE_DIRECTORY = 0;
  Integer MENU_TYPE_MENU = 1;
  Integer MENU_TYPE_BUTTON = 2;

  Integer API_ACCESS_PUBLIC = 1;
  Integer API_ACCESS_PRIVATE = 0;

  String LOGIN_VALID_SERVICE = "LoginValidService";
}
