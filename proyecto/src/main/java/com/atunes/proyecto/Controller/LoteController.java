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

import com.atunes.proyecto.Entity.Lote;
import com.atunes.proyecto.Service.LoteService;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    @Autowired
    private LoteService loteService;

    @GetMapping
    public ResponseEntity<List<Lote>> getAllLotes() {
        List<Lote> lotes = loteService.listarTodosLosLotes();
        return new ResponseEntity<>(lotes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> getLoteById(@PathVariable Long id) {
        Optional<Lote> lote = loteService.buscarLotePorId(id);
        return lote.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Lote> crearLote(@RequestBody Lote lote) {
        try {
            Lote nuevo = loteService.guardarLote(lote);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> actualizarLote(@PathVariable Long id, @RequestBody Lote lote) {
        if (id == null || !id.equals(lote.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Lote actualizado = loteService.guardarLote(lote);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLote(@PathVariable Long id) {
        try {
            loteService.eliminarLote(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
