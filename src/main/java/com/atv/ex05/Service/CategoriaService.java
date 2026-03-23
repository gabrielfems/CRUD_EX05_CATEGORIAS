package com.atv.ex05.Service;


import com.atv.ex05.Model.Categoria;
import com.atv.ex05.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> buscarCategoria(Long id){
        return categoriaRepository.findById(id);
    }

    public List<Categoria> buscarCategorias(){
        return categoriaRepository.findAll();
    }

    public void excluirCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
