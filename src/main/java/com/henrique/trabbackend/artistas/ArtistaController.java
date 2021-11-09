package com.henrique.trabbackend.artistas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/artistas")
@AllArgsConstructor

public class ArtistaController {

 @Autowired
 ArtistaRepository repository;
 
 @GetMapping("/retornaTodos")
 List<Artista> todosArtistas(){
	 return repository.findAll();
 }
 
 @PostMapping("/novo")
 Artista novoArtista(@RequestBody Artista artista) {
	 return repository.save(artista);
 }
 @GetMapping("/{id}")
 Optional<Artista> retornaArtista(@PathVariable Long id) {
	 return repository.findById(id);
 }
 
 @PutMapping("/{id}")
 Artista atualiza(@RequestBody Artista artista, @PathVariable Long id) {
	 artista.setId(id);
	 return repository.save(artista);
 }

 @DeleteMapping("/deleta/{id}")
 void deletaArtista(@PathVariable Long id) {
	 repository.deleteById(id);
 }
}
