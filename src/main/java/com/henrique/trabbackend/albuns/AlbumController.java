package com.henrique.trabbackend.albuns;

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
@RequestMapping("/albuns")
@AllArgsConstructor

public class AlbumController {

 @Autowired
 AlbumRepository repository;
 
 @GetMapping("/retornaTodos")
 List<Album> todosAlbuns(){
	 return repository.findAll();
 }
 
 @PostMapping("/novo")
 Album novoAlbum(@RequestBody Album album) {
	 return repository.save(album);
 }
 @GetMapping("/{id}")
 Optional<Album> retornaAlbum(@PathVariable Long id) {
	 return repository.findById(id);
 }
 
 @PutMapping("/{id}")
 Album atualiza(@RequestBody Album album, @PathVariable Long id) {
	 album.setId(id);
	 return repository.save(album);
 }

 @DeleteMapping("/deleta/{id}")
 void deletaAlbum(@PathVariable Long id) {
	 repository.deleteById(id);
 }
}
