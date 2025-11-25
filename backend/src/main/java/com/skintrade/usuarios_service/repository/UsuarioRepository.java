package com.skintrade.usuarios_service.repository;

import com.skintrade.usuarios_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u ORDER BY u.id DESC LIMIT 1")
    Usuario findUltimoUsuario();
}
