package com.caico.estoque.service;

import com.caico.estoque.model.Foto;
import com.caico.estoque.repository.FotoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FotoService {

    private static final String UPLOAD_DIR = "uploads/";
    private final FotoRepository fotoRepository;

    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    @Transactional
    public ResponseEntity<?> salvar(MultipartFile file)  {
        try {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String nomeSalvo = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(nomeSalvo);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        Foto foto = new Foto(file.getOriginalFilename(), nomeSalvo, filePath.toString());
        Foto fotoSalva = fotoRepository.save(foto);

        return ResponseEntity.status(HttpStatus.CREATED).body(fotoSalva);

    } catch(IOException e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar arquivo: " + e.getMessage());
        }
    }
}
