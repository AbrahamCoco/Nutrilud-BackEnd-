package com.devconmx.nutrilud_backend.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.devconmx.nutrilud_backend.model.UsersVO;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.Personal_access_tokensServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class Personal_access_tokensServiceImpl implements Personal_access_tokensServices {
    private static final Logger LOG = LoggerFactory.getLogger(Personal_access_tokensServices.class);

    @Value("${secret_key}")
    private String secretKey;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public String getSecretKey() throws AppException {
        LOG.info("Generating secret key");
        SecureRandom random = new SecureRandom();
        String secretKey = null;
        try {
            byte[] key = new byte[32];
            random.nextBytes(key);
            secretKey = Base64.getEncoder().encodeToString(key);
        } catch (Exception e) {
            Utils.raise(e, "Error generating secret key");
        }
        return secretKey;
    }

    @Override
    public UsersVO login(String usuario, String contrasenia) throws AppException {
        LOG.info("loginServices() -> usuario: *********, contrasenia: *********");
        UsersVO vo = null;
        try {
            vo = usersRepository.login(usuario, contrasenia);
            if (vo == null) {
                throw new AppException("Usuario no encontrado");
            }
            if (!vo.getUsuario().equals(usuario)) {
                throw new AppException("Usuario no encontrado");
            }
            if (!vo.getContrasenia().equals(contrasenia)) {
                throw new AppException("Contraseña incorrecta");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("Usuario inactivo");
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al iniciar sesión");
        }
        return vo;
    }

    @Override
    public String generateToken(UsersVO usersVO) throws AppException {
        LOG.info("generateTokenService() -> usersVO: {}", usersVO);
        String token = null;
        try {
            token = JWT.create()
                    .withClaim("nombre", usersVO.getNombre())
                    .withClaim("primer_apellido", usersVO.getPrimer_apellido())
                    .withClaim("segundo_apellido", usersVO.getSegundo_apellido())
                    .withClaim("id", usersVO.getId())
                    .withClaim("id_admin",
                            usersVO.getTusuario_admins() != null ? usersVO.getTusuario_admins().getId() : 0)
                    .withClaim("id_nutriologo",
                            usersVO.getTusuario_nutriologos() != null ? usersVO.getTusuario_nutriologos().getId() : 0)
                    .withClaim("id_paciente",
                            usersVO.getTusuario_pacientes() != null ? usersVO.getTusuario_pacientes().getId() : 0)
                    .withClaim("rol_id", usersVO.getTrols().getId())
                    .withClaim("role", usersVO.getTrols().getRol())
                    // 2 day in milliseconds
                    .withExpiresAt(new Date(System.currentTimeMillis() + 172800000))
                    .sign(Algorithm.HMAC256(secretKey));
        } catch (Exception e) {
            Utils.raise(e, "Error generando token");
        }
        return token;
    }

    @Override
    public String insertArchivo(MultipartFile file, String nombre, String apellido, int id) throws AppException {
        LOG.info("insertImagenService() -> nombre: {}, apellido: {}, id: {}", nombre, apellido, id);
        String rutaRelativa = null;
        try {
            if (file.isEmpty()) {
                throw new AppException("Archivo vacío");
            }

            LocalDateTime now = LocalDateTime.now();
            String contentType = file.getContentType();
            if (contentType == null) {
                throw new AppException("Tipo de contenido nulo");
            }

            // Directorio relativo para guardar el archivo
            String relativeUploadDir;
            if (contentType.equals("image/jpeg") || contentType.equals("image/png")) {
                relativeUploadDir = "uploads" + File.separator + "images" + File.separator + id + "_" + nombre + "_"
                        + apellido;
            } else if (contentType.equals("application/pdf")) {
                relativeUploadDir = "uploads" + File.separator + "pdf" + File.separator + id + "_" + nombre + "_"
                        + apellido;
            } else {
                throw new AppException("Formato de archivo no permitido");
            }

            // Directorio absoluto en el servidor
            String baseDir = System.getProperty("user.dir");
            String uploadDir = baseDir + File.separator + relativeUploadDir;

            // Crear el directorio si no existe
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            String fileName = file.getOriginalFilename();
            if (fileName == null) {
                throw new AppException("Nombre de archivo nulo");
            }

            String[] extension = fileName.split("\\.");
            if (extension.length < 2) {
                throw new AppException("Nombre de archivo sin extensión");
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String formattedNow = now.format(formatter);
            String newFileName = nombre + "_" + apellido + "_" + formattedNow + "." + extension[extension.length - 1];
            // Ruta absoluta para guardar el archivo
            String rutaAbsoluta = uploadDir + File.separator + newFileName;

            // Asegurarse de que la ruta completa existe
            Files.createDirectories(Paths.get(uploadDir));

            File dest = new File(rutaAbsoluta);
            file.transferTo(dest);

            // Construir la ruta relativa que se retornará (usando File.separator)
            rutaRelativa = relativeUploadDir.replace("uploads" + File.separator, "") + File.separator + newFileName;
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar la imagen");
        }
        return rutaRelativa;
    }
}
