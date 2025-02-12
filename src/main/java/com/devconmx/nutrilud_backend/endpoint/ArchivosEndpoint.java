package com.devconmx.nutrilud_backend.endpoint;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    private final Path fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();

    @GetMapping("/files/**")
    public ResponseEntity<Resource> downloadFile(HttpServletRequest request) {
        try {
            // Obtener la ruta completa desde la URL
            String fullPath = request.getRequestURI().replace("/api/v1/files/", "");

            // Normalizar la ruta
            Path filePath = fileStorageLocation.resolve(fullPath).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/view/**")
    public ResponseEntity<Resource> viewFile(HttpServletRequest request) {
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

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, contentType)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
