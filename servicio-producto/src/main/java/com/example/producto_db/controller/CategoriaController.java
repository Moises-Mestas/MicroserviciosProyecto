package com.example.producto_db.controller;

import com.example.producto_db.entity.Categoria;
import com.example.producto_db.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping
    public List<Categoria> listar() {
        return categoriaService.listar();
    }

    @RequestMapping("/{id}")
    public Optional<Categoria> buscar(@PathVariable Integer id) {
        return categoriaService.buscar(id);
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        System.out.println(categoria);
        return categoriaService.guardar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        return categoriaService.actualizar(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        categoriaService.eliminar(id);
    }
}
