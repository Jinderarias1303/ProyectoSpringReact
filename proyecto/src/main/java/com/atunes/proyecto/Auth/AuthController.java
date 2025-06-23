package com.atunes.proyecto.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

// Asume que tendrás un AuthService para la lógica de negocio
// Necesitarás crear las clases LoginRequest, RegisterRequest y AuthResponse
// estas son clases DTO (Data Transfer Object) para manejar la entrada y salida de datos
import com.atunes.proyecto.Auth.Request.LoginRequest;
import com.atunes.proyecto.Auth.Request.RegisterRequest;
import com.atunes.proyecto.Auth.Response.AuthResponse;


@RestController
@RequestMapping("/api/auth") // **CAMBIO IMPORTANTE:** Cambiado a /api/auth para coherencia
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService; // Inyecta tu nuevo servicio de autenticación

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}