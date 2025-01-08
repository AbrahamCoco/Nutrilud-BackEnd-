package com.devconmx.nutrilud_backend.service;

import com.devconmx.nutrilud_backend.model.UsersDTO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface UsersServices {
    boolean verifyUser(UsersDTO usersDTO) throws AppException;
}
