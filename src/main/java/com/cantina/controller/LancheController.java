package com.cantina.controller;

import com.cantina.dto.LancheListaDTO;
import com.cantina.dto.LancheRequestDTO;
import com.cantina.dto.LancheResponseDTO;
import com.cantina.model.Lanche;
import com.cantina.service.LancheService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cantina-api")
public class LancheController {

    @Autowired
    private LancheService lancheService;

    @PostMapping()
    public ResponseEntity<LancheResponseDTO> cadastrar(@Valid @RequestBody LancheRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lancheService.cadastrar(dto));
    }

    @GetMapping()
    public ResponseEntity<List<LancheListaDTO>> listar() {
        return ResponseEntity.ok(lancheService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> filtrarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(lancheService.filtrarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> atualizar(@PathVariable Long id,@Valid @RequestBody LancheRequestDTO dto) {
        return ResponseEntity.ok(lancheService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLanche(@PathVariable Long id) {
        lancheService.deletarLanche(id);

        return ResponseEntity.noContent().build();
    }
}
