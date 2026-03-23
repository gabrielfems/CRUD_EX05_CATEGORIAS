package com.atv.ex05.Controller;

import com.atv.ex05.Model.Categoria;
import com.atv.ex05.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarCategorias(){
        List<Categoria> categorias = categoriaService.buscarCategorias();
        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){
        Optional<Categoria> busca = categoriaService.buscarCategoria(id);
        return ResponseEntity.ok().body(busca.get());
    }

    @PostMapping
    public ResponseEntity<Categoria> inserirCategoria(@RequestBody Categoria categoria){
        Categoria cat = categoriaService.criarCategoria(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(cat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> deletarCategoria(@PathVariable Long id){
        categoriaService.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
