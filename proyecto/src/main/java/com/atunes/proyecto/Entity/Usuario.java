package com.atunes.proyecto.Entity;

import java.util.Collection;
import java.util.Collections; // Importar Collections
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.atunes.proyecto.enums.TipoRol; // **NUEVO:** Importar el Enum TipoRol

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements org.springframework.security.core.userdetails.UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_rol") // **MUY IMPORTANTE:** Asegúrate que tu columna en la BD se llama 'id_rol'
    private Roles idRol;

    public enum Estado {
        Activo,
        Inactivo
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.idRol != null && this.idRol.getTipoRol() != null) {
            // **CAMBIO CRUCIAL:** Mapea el Enum TipoRol a una autoridad con prefijo "ROLE_"
            return java.util.List.of(new SimpleGrantedAuthority("ROLE_" + this.idRol.getTipoRol().name().toUpperCase()));
        }
        return Collections.emptyList(); // Devuelve una lista vacía inmutable
    }

    @Override
    public boolean isAccountNonExpired() {
       return true; // Considera implementar lógica real si necesitas expiración de cuenta
    }
    @Override
    public boolean isAccountNonLocked() {
       return true; // Considera implementar lógica real si necesitas bloqueo de cuenta
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Considera implementar lógica real si necesitas expiración de credenciales
    }
    @Override
    public boolean isEnabled() {
        // **CAMBIO:** Usa el estado de tu entidad para determinar si el usuario está habilitado
        return this.estado == Estado.Activo;
    }

    // Los getters de username y password son generados por Lombok @Data, pero si no usaras Lombok,
    // tendrías que implementarlos explícitamente:
    // @Override
    // public String getUsername() { return username; }
    // @Override
    // public String getPassword() { return password; }
}