package com.skintrade.usuarios_service.service;

import com.skintrade.usuarios_service.dto.UsuarioRequest;
import com.skintrade.usuarios_service.model.Usuario;
import com.skintrade.usuarios_service.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario crearUsuario(UsuarioRequest request) {
        Usuario u = new Usuario(
                request.getNombre(),
                request.getCorreo(),
                request.getDireccion()
        );
        return repository.save(u);
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Usuario obtenerUltimo() {
        return repository.findUltimoUsuario();
    }
}
