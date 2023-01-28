package com.sistema.canchas.service;

import com.sistema.canchas.model.Rol;
import com.sistema.canchas.model.Usuario;
import com.sistema.canchas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return usuarioRepository;
    }

    @Override
    public Usuario login(String username, String password) {

        return usuarioRepository.findByUsernameAndPassword(username, password);
    }


    public boolean porUsername(String username) {
        if (usuarioRepository.findByUsername(username)!=null) {
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Optional<Usuario> porId(Long idUsuario) {

        return usuarioRepository.findById(idUsuario);
    }
}
