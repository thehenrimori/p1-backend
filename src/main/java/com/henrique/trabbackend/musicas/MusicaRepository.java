package com.henrique.trabbackend.musicas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long>{
	
	List<Musica> findAllByArtista(Long id);
	List<Musica> findAllByAlbum(Long id);
	
	
}