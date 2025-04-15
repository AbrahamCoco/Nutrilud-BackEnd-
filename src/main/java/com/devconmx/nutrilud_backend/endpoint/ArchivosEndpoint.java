package com.devconmx.nutrilud_backend.endpoint;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController()
@CrossOrigin(origins = "*")
public class ArchivosEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(ArchivosEndpoint.class);

    private final Path fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();

    @GetMapping("/files/**")
    public ResponseEntity<Resource> downloadFile(HttpServletRequest request) {
        LOG.info("downloadFileEndpoint()");
        try {
            // Obtener la ruta completa desde la URL
            String fullPath = request.getRequestURI().replace("/api/v1/files/", "");

            // Normalizar la ruta
            Path filePath = fileStorageLocation.resolve(fullPath).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                LOG.info("downloadFileEndpoint() -> OK");
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                LOG.info("downloadFileEndpoint() -> NOT FOUND");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            LOG.error("downloadFileEndpoint() -> INTERNAL SERVER ERROR");
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/view/**")
    public ResponseEntity<Resource> viewFile(HttpServletRequest request) {
        LOG.info("viewFileEndpoint()");
        try {
            // Obtener la ruta completa desde la URL
            String fullPath = request.getRequestURI().replace("/api/v1/view/", "");

            // Normalizar la ruta
            Path filePath = fileStorageLocation.resolve(fullPath).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                // Obtener el tipo MIME del archivo
                String contentType = Files.probeContentType(filePath);
                if (contentType == null) {
                    contentType = "application/octet-stream"; // Tipo genérico en caso de fallo
                }

                LOG.info("viewFileEndpoint() -> OK");
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, contentType)
                        .body(resource);
            } else {
                LOG.info("viewFileEndpoint() -> NOT FOUND");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            LOG.error("viewFileEndpoint() -> INTERNAL SERVER ERROR");
            return ResponseEntity.internalServerError().build();
        }
    }
}
