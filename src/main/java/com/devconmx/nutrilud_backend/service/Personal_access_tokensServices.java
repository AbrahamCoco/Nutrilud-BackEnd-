package com.devconmx.nutrilud_backend.service;

import org.springframework.web.multipart.MultipartFile;

import com.devconmx.nutrilud_backend.model.vos.UsersVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface Personal_access_tokensServices {
    String getSecretKey() throws AppException;

    UsersVO login(String usuario, String contrasenia) throws AppException;

    String generateToken(UsersVO usersVO) throws AppException;

    String insertArchivo(MultipartFile file, String nombre, String apellido, int id) throws AppException;
}
