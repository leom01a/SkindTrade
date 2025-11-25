package com.skintrade.usuarios_service.controller;

import com.skintrade.usuarios_service.dto.UsuarioRequest;
import com.skintrade.usuarios_service.model.Usuario;
import com.skintrade.usuarios_service.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioRequest request) {
        Usuario creado = service.crearUsuario(request);
        return ResponseEntity
                .created(URI.create("/api/usuarios/" + creado.getId()))
                .body(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = service.obtenerPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ultimo")
    public ResponseEntity<Usuario> obtenerUltimo() {
        Usuario ultimo = service.obtenerUltimo();
        if (ultimo == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ultimo);
    }
}
