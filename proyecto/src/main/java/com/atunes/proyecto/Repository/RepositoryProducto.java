package com.atunes.proyecto.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atunes.proyecto.Entity.Producto;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreProducto(String nombre); // usa camelCase como en la entidad
}
