package com.atunes.proyecto.Auth.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    Long idRol; // Podrías necesitar un campo para el ID del rol al registrar
    // String tipoRol; // O podrías enviar el nombre del rol y buscarlo en el servicio
    // Asegúrate de que el estado por defecto sea Activo o lo manejes aquí
}