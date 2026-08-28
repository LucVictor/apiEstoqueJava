package com.caico.estoque.service;

import com.caico.estoque.dto.usuario.UsuarioLoginDTO;
import com.caico.estoque.dto.usuario.UsuarioDTO;
import com.caico.estoque.dto.usuario.UsuarioRegistroDTO;
import com.caico.estoque.model.Usuario;
import com.caico.estoque.repository.UsuarioRepository;
import com.caico.estoque.security.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AutenticacaoService(
            AuthenticationManager authenticationManager,
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UsuarioDTO login(UsuarioLoginDTO request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.usuario(),
                                request.senha()
                        )
                );

        Usuario usuario =
                (Usuario) authentication.getPrincipal();

        String token =
                jwtService.gerarToken(usuario);

        return new UsuarioDTO(usuario.getUsuario(), usuario.getNome(), usuario.getFilial(), token);
    }

    public void registrar(UsuarioRegistroDTO request) {

        if (usuarioRepository.existsByUsuario(request.usuario())) {
            throw new IllegalArgumentException(
                    "Usuário já cadastrado"
            );
        }

        Usuario usuario = new Usuario(
                request.usuario(),
                passwordEncoder.encode(request.senha()),
                request.nome(),
                request.filial(),
                request.role()
        );

        usuarioRepository.save(usuario);
    }

}