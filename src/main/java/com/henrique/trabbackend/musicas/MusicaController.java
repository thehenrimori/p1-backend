package com.henrique.trabbackend.musicas;

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

import com.henrique.trabbackend.artistas.Artista;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/musicas")
@AllArgsConstructor

public class MusicaController {
@Autowired
MusicaRepository repository;

@GetMapping("/retornaTodas")
List<Musica>todosPratos(){
	return repository.findAll();
}

@PostMapping("/novo")
Musica novaMusica (@RequestBody Musica musica) {
	return repository.save(musica);
}

@GetMapping("/{id}")
Optional <Musica> retornaMusica(@PathVariable Long id){
	return repository.findById(id);
	
}

@PutMapping("/{id}")
Musica atualizaMusica(@RequestBody Musica musica, @PathVariable Long id) {
	 musica.setId(id);
	 return repository.save(musica);
}

@DeleteMapping("/deleta/{id}")
void deletaMusica(@PathVariable Long id) {
	 repository.deleteById(id);
}
}

