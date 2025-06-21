package com.atunes.proyecto.Controller;

import java.util.List;

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

import com.atunes.proyecto.Entity.Defecto;
import com.atunes.proyecto.Service.DefectoService;

@RestController
@RequestMapping("/api/defectos")
public class DefectoController {

    @Autowired
    private DefectoService defectoService;

    @GetMapping
    public ResponseEntity<List<Defecto>> getAllDefectos() {
        List<Defecto> defectos = defectoService.listarTodosLosDefectos();
        return new ResponseEntity<>(defectos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Defecto> createDefecto(@RequestBody Defecto defecto) {
        try {
            Defecto savedDefecto = defectoService.guardarDefecto(defecto);
            return new ResponseEntity<>(savedDefecto, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Defecto> updateDefecto(@PathVariable Long id, @RequestBody Defecto defecto) {
        if (id == null || !id.equals(defecto.getId())) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        try {
            Defecto updatedDefecto = defectoService.guardarDefecto(defecto);
            return new ResponseEntity<>(updatedDefecto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDefecto(@PathVariable Long id) {
        try {
            defectoService.eliminarDefecto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
