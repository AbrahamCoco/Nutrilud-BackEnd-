package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.beans.PacientesBean;
import com.devconmx.nutrilud_backend.model.dtos.UsersDTO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface UsersServices {

    List<PacientesBean> findAllPacientes() throws AppException;

    PacientesBean findByIdPaciente(int id) throws AppException;

    void deleteByIdPaciente(int id) throws AppException;

    void insert(UsersDTO usersDTO) throws AppException;

    UsersVO findById(int id) throws AppException;

    List<UsersVO> findAllAdminsAndNutris() throws AppException;
}
