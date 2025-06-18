package com.atunes.proyecto.Controller;

import java.util.List;
import java.util.Optional;

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

import com.atunes.proyecto.Entity.LoteDefectuoso;
import com.atunes.proyecto.Service.LoteDefectuosoService;

@RestController
@RequestMapping("/api/lotes-defectuosos")
public class LoteDefectuosoController {

    @Autowired
    private LoteDefectuosoService loteDefectuosoService;

    @GetMapping
    public ResponseEntity<List<LoteDefectuoso>> listarTodos() {
        List<LoteDefectuoso> lotes = loteDefectuosoService.listarTodos();
        return new ResponseEntity<>(lotes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoteDefectuoso> buscarPorId(@PathVariable Long id) {
        Optional<LoteDefectuoso> lote = loteDefectuosoService.buscarPorId(id);
        return lote.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LoteDefectuoso> guardar(@RequestBody LoteDefectuoso loteDefectuoso) {
        try {
            LoteDefectuoso nuevo = loteDefectuosoService.guardar(loteDefectuoso);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoteDefectuoso> guardar(@PathVariable Long id, @RequestBody LoteDefectuoso loteDefectuoso) {
        if (id == null || !id.equals(loteDefectuoso.getId())) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        try {
            LoteDefectuoso actualizado = loteDefectuosoService.guardar(loteDefectuoso);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        try {
            loteDefectuosoService.eliminarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
