package com.devconmx.nutrilud_backend.service.impl;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.UsersDTO;
import com.devconmx.nutrilud_backend.model.UsersVO;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.UsersServices;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class UsersServiceImpl implements UsersServices {
    private static final Logger LOG = LoggerFactory.getLogger(UsersServices.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean verifyUser(UsersDTO usersDTO) throws AppException {
        LOG.info("VerifyUser->Users");
        try {
            String usuarioInput = usersDTO.getUsuario();
            LOG.info("Usuario input: {}", usuarioInput);
            String contraseniaInput = usersDTO.getContrasenia();
            LOG.info("Contrasenia input: {}", contraseniaInput);

            List<UsersVO> userVoList = usersRepository.verifyUserRepository(usuarioInput, contraseniaInput);
            LOG.info("Usuario bd verificado: {}", userVoList.get(0).getUsuario());

            if (Objects.equals(usuarioInput, userVoList.get(0).getUsuario())
                    && Objects.equals(contraseniaInput, userVoList.get(0).getContrasenia())) {
                LOG.info("Input usuario verificado: {}", usuarioInput);
                LOG.info("Input contrasenia verificado: {}", contraseniaInput);
                LOG.info("BD usuario verificado: {}", userVoList.get(0).getUsuario());
                LOG.info("BD contrasenia verificado: {}", userVoList.get(0).getContrasenia());
                return true;
            } else {
                LOG.info("Input usuario verificado: {}", usuarioInput);
                LOG.info("Input contrasenia verificado: {}", contraseniaInput);
                LOG.info("BD usuario verificado: {}", userVoList.get(0).getUsuario());
                LOG.info("BD contrasenia verificado: {}", userVoList.get(0).getContrasenia());
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
