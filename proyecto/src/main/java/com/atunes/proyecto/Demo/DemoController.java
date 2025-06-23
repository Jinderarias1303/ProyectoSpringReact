package com.atunes.proyecto.Demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1") // esta es la ruta de la base de la API
@RequiredArgsConstructor
public class DemoController {


    @PostMapping(value = "demo")
    public String Welcome() {
    return "welcome from secure endpoint";
    }
    
}
