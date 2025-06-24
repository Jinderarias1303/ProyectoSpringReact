package com.atunes.proyecto.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

// Asegúrate de que estas clases existan en tu proyecto
// Son DTOs (Data Transfer Objects) para la entrada y salida de datos
import com.atunes.proyecto.Auth.Request.LoginRequest;
import com.atunes.proyecto.Auth.Request.RegisterRequest;
import com.atunes.proyecto.Auth.Response.AuthResponse;


@RestController
@RequestMapping("/api/auth") // Ruta base para los endpoints de autenticación
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService; // Inyecta tu servicio de autenticación

    @PostMapping(value = "login") // La URL completa será /api/auth/login
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register") // La URL completa será /api/auth/register
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}