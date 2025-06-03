package com.pedro.teste.service;

import com.pedro.teste.dto.UsuarioRequestDTO;
import com.pedro.teste.dto.UsuarioResponseDTO;
import com.pedro.teste.model.Usuario;
import com.pedro.teste.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        Usuario response = usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(response);
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));
        return new UsuarioResponseDTO(usuario);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        Usuario response = usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(response);
    }

    public void deletar(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new EntityNotFoundException("Usuario não encontrado com id: " + id);
        }
    }
}
