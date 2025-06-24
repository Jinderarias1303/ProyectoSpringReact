package com.atunes.proyecto.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // Importante para habilitar la configuración de Spring MVC
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica esta configuración CORS a todas las rutas de tu API
                .allowedOrigins("http://localhost:5174") // ***Este es el ORIGEN de tu frontend que se permite***
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos los encabezados en las solicitudes
                .allowCredentials(true); // Necesario si envías cookies o el encabezado Authorization
    }
}