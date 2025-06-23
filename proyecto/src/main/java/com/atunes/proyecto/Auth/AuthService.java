package com.atunes.proyecto.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atunes.proyecto.Auth.Request.LoginRequest;
import com.atunes.proyecto.Auth.Request.RegisterRequest;
import com.atunes.proyecto.Auth.Response.AuthResponse;
import com.atunes.proyecto.Entity.Roles;
import com.atunes.proyecto.Entity.Usuario;
import com.atunes.proyecto.Entity.Usuario.Estado;
import com.atunes.proyecto.Jwt.JwtService;
import com.atunes.proyecto.Repository.RepositoryRoles; // Necesitarás un repositorio para Roles
import com.atunes.proyecto.Repository.RepositoryUsuario;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RepositoryUsuario userRepository;
    private final RepositoryRoles rolesRepository; // **NUEVO:** Para buscar roles
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager; // Inyecta el AuthenticationManager

    public AuthResponse login(LoginRequest request) {
        // Autentica al usuario usando el AuthenticationManager
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        // Si la autenticación es exitosa, carga los detalles del usuario
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        // Genera el token JWT
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        // **IMPORTANTE:** Aquí se asume que pasas el ID del rol o el nombre del rol.
        // Si pasas el ID (como en el ejemplo de RegisterRequest), debes buscar el rol por ID.
        // Si pasas el nombre (ej. "Cliente", "Operador"), debes buscarlo por nombre.

        // Buscar el rol por ID. Asumo que el rol con id = 1 es 'Cliente' por defecto si no se especifica.
        Roles defaultRole = rolesRepository.findById(request.getIdRol() != null ? request.getIdRol() : 1L) // Usa el ID del rol de la request, o 1L (Cliente) por defecto
                                .orElseThrow(() -> new RuntimeException("Role not found")); // O una excepción personalizada

        // Construye el nuevo usuario
        Usuario user = Usuario.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword())) // **HASHEAR CONTRASEÑA**
            .estado(Estado.Activo) // Por defecto, Activo al registrarse
            .idRol(defaultRole) // Asigna el rol
            .build();

        userRepository.save(user); // Guarda el usuario en la base de datos

        // Genera el token JWT para el nuevo usuario registrado
        String token = jwtService.getToken(user);

        return AuthResponse.builder()
            .token(token)
            .build();
    }
}