package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.UsersDTO;
import com.devconmx.nutrilud_backend.model.UsersVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface UsersServices {

    List<UsersVO> findAllPacientes() throws AppException;

    UsersVO findByIdPaciente(int id) throws AppException;

    void deleteByIdPaciente(int id) throws AppException;

    void insert(UsersDTO usersDTO) throws AppException;
}
