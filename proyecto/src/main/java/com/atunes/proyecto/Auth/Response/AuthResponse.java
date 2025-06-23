package com.atunes.proyecto.Auth.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;
    // Puedes añadir más campos aquí, como el username del usuario, roles, etc.
    // String username;
    // List<String> roles;
}