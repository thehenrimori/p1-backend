package com.henrique.trabbackend.musicas;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.henrique.trabbackend.artistas.Artista;
import com.henrique.trabbackend.albuns.Album;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Musica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Double preco;
	
	@ManyToOne
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private Artista artista;
	
	@ManyToOne
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private Album album;
	
	@NotNull
	private String nome;
	private String tipo;
	private Integer minutos;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getMinutos() {
		return minutos;
	}
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
	

}
