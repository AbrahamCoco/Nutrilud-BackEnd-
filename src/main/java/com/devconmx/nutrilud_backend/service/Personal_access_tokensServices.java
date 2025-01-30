package com.devconmx.nutrilud_backend.service;

import com.devconmx.nutrilud_backend.model.UsersVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface Personal_access_tokensServices {
    String getSecretKey() throws AppException;

    UsersVO login(String usuario, String contrasenia) throws AppException;

    String generateToken(UsersVO usersVO) throws AppException;
}
