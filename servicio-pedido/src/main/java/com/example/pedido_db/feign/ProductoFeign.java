package com.example.pedido_db.feign;

import com.example.pedido_db.dto.Producto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "producto-db-service", path = "/productos")
public interface ProductoFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "productoCircuitBreaker", fallbackMethod = "fallbackProductoById")
    ResponseEntity<Producto> listById(@PathVariable Integer id);

    // Fallback method en el mismo Feign
    default ResponseEntity<Producto> fallbackProductoById(Integer id, Throwable e) {
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre("Producto no disponible");
        producto.setCategoria(null);  // Suponemos que la categoría es un objeto, por lo tanto, dejamos null si no se encuentra
        producto.setDescripcion("Descripción no disponible");
        producto.setPrecio(BigDecimal.ZERO);  // Aquí cambiamos a BigDecimal.ZERO
        producto.setStock(0);  // Establecer a 0 si el producto no está disponible

        return ResponseEntity.ok(producto);
    }
}
