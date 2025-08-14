package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.beans.PacientesBean;
import com.devconmx.nutrilud_backend.model.beans.UserBean;
import com.devconmx.nutrilud_backend.model.builders.UsersBuilder;
import com.devconmx.nutrilud_backend.model.dtos.Tusuario_adminsDTO;
import com.devconmx.nutrilud_backend.model.dtos.Tusuario_nutriologosDTO;
import com.devconmx.nutrilud_backend.model.dtos.Tusuario_pacientesDTO;
import com.devconmx.nutrilud_backend.model.dtos.UsersDTO;
import com.devconmx.nutrilud_backend.model.vos.Tdatos_consultasVO;
import com.devconmx.nutrilud_backend.model.vos.TrolsVO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_adminsVO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_nutriologosVO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_pacientesVO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;
import com.devconmx.nutrilud_backend.repository.Tdatos_consultasRepository;
import com.devconmx.nutrilud_backend.repository.TrolsRepository;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.Tusuario_adminsServices;
import com.devconmx.nutrilud_backend.service.Tusuario_nutriologosServices;
import com.devconmx.nutrilud_backend.service.Tusuario_pacientesServices;
import com.devconmx.nutrilud_backend.service.UsersServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class UsersServiceImpl implements UsersServices {
    private static final Logger LOG = LoggerFactory.getLogger(UsersServices.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private Tusuario_adminsServices tusuario_adminsServices;

    @Autowired
    private Tusuario_nutriologosServices tusuario_nutriologosServices;

    @Autowired
    private Tusuario_pacientesServices tusuario_pacientesServices;

    @Autowired
    private TrolsRepository trolsRepository;

    @Autowired
    private Tdatos_consultasRepository consultasRepository;

    @Override
    public List<PacientesBean> findAllPacientes() throws AppException {
        LOG.info("findAllPacientes()");
        List<UsersVO> vo = null;
        List<PacientesBean> pacientes = new ArrayList<>();
        try {
            vo = usersRepository.findByPaciente();
            if (vo == null) {
                throw new AppException("No se encontraron pacientes");
            }

            vo.forEach(user -> {
                PacientesBean bean = new PacientesBean();
                bean.setId(user.getId());
                bean.setId_paciente(user.getTusuario_pacientes().getId());
                bean.setNombrePaciente(user.getNombre() + " " + user.getPrimer_apellido() + " " + user.getSegundo_apellido());
                bean.setSexo(user.getTusuario_pacientes().getSexo());
                bean.setCorreo(user.getCorreo());
                bean.setTelefono(user.getTusuario_pacientes().getTelefono());
                bean.setFechaNacimiento(user.getTusuario_pacientes().getFecha_nacimiento());
                bean.setAlergias(user.getTusuario_pacientes().getAlergias());
                pacientes.add(bean);
            });
            LOG.info("findAllPacientes() -> Listado de pacientes");
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar pacientes");
        }
        return pacientes;
    }

    @Override
    public PacientesBean findByIdPaciente(int id) throws AppException {
        LOG.info("findByIdPaciente() -> id: {}", id);
        UsersVO vo = null;
        PacientesBean paciente = null;
        try {
            vo = usersRepository.findByIdPaciente(id);
            if (vo == null) {
                throw new AppException("No se encontro el paciente");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El paciente esta deshabilitado");
            }

            paciente = new PacientesBean();
            paciente.setId(vo.getId());
            paciente.setId_paciente(vo.getTusuario_pacientes().getId());
            paciente.setNombrePaciente(vo.getNombre() + " " + vo.getPrimer_apellido() + " " + vo.getSegundo_apellido());
            paciente.setSexo(vo.getTusuario_pacientes().getSexo());
            paciente.setCorreo(vo.getCorreo());
            paciente.setTelefono(vo.getTusuario_pacientes().getTelefono());
            paciente.setUsuario(vo.getUsuario());
            paciente.setFechaNacimiento(vo.getTusuario_pacientes().getFecha_nacimiento());
            paciente.setAlergias(vo.getTusuario_pacientes().getAlergias());

            LOG.info("findByIdPaciente() -> Paciente encontrado");
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar paciente");
        }
        return paciente;
    }

    @Override
    public void deleteByIdPaciente(int id) throws AppException {
        LOG.info("deleteByIdPaciente() -> id: {}", id);
        UsersVO vo = null;
        try {
            vo = usersRepository.findByIdPaciente(id);
            if (vo == null) {
                throw new AppException("No se encontro el paciente");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El paciente esta deshabilitado");
            }
            vo.setEstado(0);
            usersRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al eliminar paciente");
        }
    }

    @Override
    public void insert(UsersDTO usersDTO) throws AppException {
        LOG.info("insertUserService() -> usersDTO: {}", usersDTO);
        UsersVO vo = null;
        Tusuario_adminsDTO adminDTO = new Tusuario_adminsDTO();
        Tusuario_nutriologosDTO nutriologoDTO = new Tusuario_nutriologosDTO();
        Tusuario_pacientesDTO pacienteDTO = new Tusuario_pacientesDTO();

        try {
            if (validateUser(usersDTO.getUsuario())) {
                throw new AppException("El usuario ya existe");
            }

            String password = usersDTO.getContrasenia();
            if (password == null || password.isEmpty()) {
                throw new AppException("La contraseña es requerida");
            }

            vo = UsersBuilder.fromDTO(usersDTO);
            if (usersDTO.getRol_id() == 1) {
                adminDTO.setDescripcion(usersDTO.getDescripcion_admin());
                adminDTO.setFoto(usersDTO.getFoto_admin());
                adminDTO.setTelefono(usersDTO.getTelefono_admin());
                Tusuario_adminsVO admin = tusuario_adminsServices.insert(adminDTO);
                vo.setTusuario_admins(admin);
            } else if (usersDTO.getRol_id() == 2) {
                nutriologoDTO.setDescripcion(usersDTO.getDescripcion_nutriologo());
                nutriologoDTO.setFoto(usersDTO.getFoto_nutriologo());
                nutriologoDTO.setDireccion(usersDTO.getDireccion_nutriologo());
                nutriologoDTO.setTelefono(usersDTO.getTelefono_nutriologo());
                nutriologoDTO.setCedula_profesional(usersDTO.getCedula_profesional_nutriologo());
                Tusuario_nutriologosVO nutriologo = tusuario_nutriologosServices.insert(nutriologoDTO);
                vo.setTusuario_nutriologos(nutriologo);
            } else if (usersDTO.getRol_id() == 3) {
                pacienteDTO.setFoto(usersDTO.getFoto_paciente());
                pacienteDTO.setTelefono(usersDTO.getTelefono_paciente());
                pacienteDTO.setFecha_nacimiento(usersDTO.getFecha_nacimiento_paciente());
                pacienteDTO.setSexo(usersDTO.getSexo_paciente());
                pacienteDTO.setAlergias(usersDTO.getAlergias_paciente());
                Tusuario_pacientesVO paciente = tusuario_pacientesServices.insert(pacienteDTO);
                vo.setTusuario_pacientes(paciente);
            } else {
                throw new AppException("El rol no es valido");
            }

            TrolsVO rol = trolsRepository.findById(usersDTO.getRol_id());
            vo.setTrols(rol);
            vo.setEstado(1);
            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            usersRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al guardar el usuario");
        }
    }

    @Override
    public UserBean findById(int id) throws AppException {
        LOG.info("findByIdService() -> id: {}", id);
        UsersVO vo = null;
        List<Tdatos_consultasVO> consultas = null;
        UserBean userBean = null;
        try {
            vo = usersRepository.findById(id);
            consultas = consultasRepository.findByPacienteVO(id);
            if (vo == null) {
                throw new AppException("No se encontro el usuario");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El usuario esta deshabilitado");
            }

            userBean = new UserBean();
            userBean.setId(vo.getId());
            userBean.setNombre(vo.getNombre() + " " + vo.getPrimer_apellido() + " " + vo.getSegundo_apellido());
            userBean.setCorreo(vo.getCorreo());

            if (vo.getTusuario_admins() != null) {
                userBean.setFoto(vo.getTusuario_admins().getFoto());
                userBean.setTelefono(vo.getTusuario_admins().getTelefono());
                userBean.setDescripcion(vo.getTusuario_admins().getDescripcion());
            }

            if (vo.getTusuario_nutriologos() != null) {
                userBean.setFoto(vo.getTusuario_nutriologos().getFoto());
                userBean.setTelefono(vo.getTusuario_nutriologos().getTelefono());
                userBean.setDireccion(vo.getTusuario_nutriologos().getDireccion());
                userBean.setCedula(vo.getTusuario_nutriologos().getCedula_profesional());
                userBean.setDescripcion(vo.getTusuario_nutriologos().getDescripcion());
            }

            if (vo.getTusuario_pacientes() != null) {
                userBean.setFoto(vo.getTusuario_pacientes().getFoto());
                userBean.setAlergias(vo.getTusuario_pacientes().getAlergias());
                userBean.setFechaNacimiento(vo.getTusuario_pacientes().getFecha_nacimiento());
                userBean.setSexo(vo.getTusuario_pacientes().getSexo());
                userBean.setTelefono(vo.getTusuario_pacientes().getTelefono());
                
                if (consultas != null && !consultas.isEmpty()) {
                    Tdatos_consultasVO ultimaConsulta = consultas.get(consultas.size() - 1);
                    userBean.setPeso(ultimaConsulta.getPeso());
                    userBean.setEstatura(ultimaConsulta.getEstatura());
                    userBean.setImc(ultimaConsulta.getImc());
                }
            }

        } catch (Exception e) {
            Utils.raise(e, "Error al buscar usuario");
        }
        LOG.info("findByIdService() -> Usuario encontrado");
        return userBean;
    }

    public boolean validateUser(String user) throws AppException {
        if (user == null || user.isEmpty()) {
            return false;
        }
        UsersVO vo = usersRepository.findByUser(user);
        if (vo != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<UsersVO> findAllAdminsAndNutris() throws AppException {
        LOG.info("findAllAdminsAndNutrisService()");
        List<UsersVO> vo = null;
        try {
            vo = usersRepository.findAllAdminsAndNutris();
            if (vo == null) {
                throw new AppException("No se encontraron administradores y nutriologos");
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar administradores y nutriologos");
        }
        LOG.info("findAllAdminsAndNutrisService() -> Listado de administradores y nutriologos");
        return vo;
    }

    @Override
    public void updatePaciente(int id, UsersDTO usersDTO) throws AppException {
        LOG.info("updatePaciente() -> id: {}, UsersDTO: {}", id, usersDTO);
        UsersVO vo = null;
        Tusuario_pacientesVO pacienteVO = null;

        try {
            vo = usersRepository.findById(id);
            if (vo == null) {
                throw new AppException("No se encontro el usuario");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El usuario esta deshabilitado");
            }

            pacienteVO = vo.getTusuario_pacientes();
            if (pacienteVO == null) {
                throw new AppException("El usuario no es un paciente");
            }

            vo.setNombre(usersDTO.getNombre());
            vo.setPrimer_apellido(usersDTO.getPrimer_apellido());
            vo.setSegundo_apellido(usersDTO.getSegundo_apellido());
            vo.setUsuario(usersDTO.getUsuario());
            vo.setCorreo(usersDTO.getCorreo());

            pacienteVO.setTelefono(usersDTO.getTelefono_paciente());
            pacienteVO.setFecha_nacimiento(usersDTO.getFecha_nacimiento_paciente());
            pacienteVO.setSexo(usersDTO.getSexo_paciente());
            pacienteVO.setAlergias(usersDTO.getAlergias_paciente());
            pacienteVO.setFoto(usersDTO.getFoto_paciente());
            pacienteVO.setUpdated_at(LocalDateTime.now());
            
            vo.setUpdated_at(LocalDateTime.now());

            vo.setTusuario_pacientes(pacienteVO);

            usersRepository.save(vo);
            LOG.info("updatePacienteService() -> Paciente actualizado correctamente");
        } catch (Exception e) {
            Utils.raise(e, "Error al actualizar el paciente");
        }
    }
}
