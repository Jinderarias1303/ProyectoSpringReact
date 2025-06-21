package com.atunes.proyecto.Controller;

import java.util.List;

import com.atunes.proyecto.Entity.Roles;
import com.atunes.proyecto.Service.RolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> roles = rolesService.listarTodosLosRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Roles> crearRol(@RequestBody Roles rol) {
        try {
            Roles nuevo = rolesService.guardarRol(rol);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> actualizarRol(@PathVariable Long id, @RequestBody Roles rol) {
        if (id == null || !id.equals(rol.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Roles actualizado = rolesService.guardarRol(rol);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        try {
            rolesService.eliminarRol(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
