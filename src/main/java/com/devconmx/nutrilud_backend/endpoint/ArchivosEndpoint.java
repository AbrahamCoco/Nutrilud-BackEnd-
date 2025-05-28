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

@RestController
@CrossOrigin(origins = "*")
public class ArchivosEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(ArchivosEndpoint.class);

    // Ruta base en el servidor (EC2 - Linux)
    private final Path fileStorageLocation = Paths.get("/home/ubuntu/uploads").toAbsolutePath().normalize();

    /**
     * Endpoint para descargar archivos
     */
    @GetMapping("/files/**")
    public ResponseEntity<Resource> downloadFile(HttpServletRequest request) {
        LOG.info("downloadFileEndpoint()");
        try {
            // Obtener la ruta completa desde la URL
            String fullPath = request.getRequestURI().substring(request.getRequestURI().indexOf("/api/v1/files/") + 7);

            // Normalizar la ruta del archivo
            Path filePath = fileStorageLocation.resolve(fullPath).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                LOG.info("downloadFileEndpoint() -> NOT FOUND");
                return ResponseEntity.notFound().build();
            }

            // Detectar el tipo MIME del archivo
            String contentType = Files.probeContentType(filePath);
            if (contentType == null) {
                contentType = "application/octet-stream"; // Tipo genérico si no se detecta
            }

            // Si es imagen o PDF, mostrar en el navegador; si no, forzar la descarga
            String contentDisposition = (contentType.startsWith("image/") || contentType.equals("application/pdf"))
                    ? "inline"
                    : "attachment";

            LOG.info("downloadFileEndpoint() -> OK: {}", resource.getFilename());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType)
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            contentDisposition + "; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (Exception e) {
            LOG.error("downloadFileEndpoint() -> INTERNAL SERVER ERROR", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Endpoint para visualizar archivos (imágenes y PDFs)
     */
    @GetMapping("/view/**")
    public ResponseEntity<Resource> viewFile(HttpServletRequest request) {
        LOG.info("viewFileEndpoint()");
    try {
        // CORREGIDO: +13 para eliminar "/api/v1/view/"
        String fullPath = request.getRequestURI().substring(request.getRequestURI().indexOf("/api/v1/view/") + 13);
        
        Path filePath = fileStorageLocation.resolve(fullPath).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            LOG.warn("Archivo no encontrado: {}", filePath);
            return ResponseEntity.notFound().build();
        }

        String contentType = Files.probeContentType(filePath);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(resource);

    } catch (Exception e) {
        LOG.error("Error al visualizar archivo", e);
        return ResponseEntity.internalServerError().build();
    }
    }
}
