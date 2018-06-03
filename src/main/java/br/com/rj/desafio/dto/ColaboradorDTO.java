package br.com.rj.desafio.dto;

import java.util.Optional;

import br.com.rj.desafio.entity.Colaborador;

public class ColaboradorDTO {

	public String nome;
	public String email;
	public String descSetor;
	
	
	public ColaboradorDTO() {}
	
	public ColaboradorDTO(String nome, String email, String descSetor) {
		super();
		this.nome = nome;
		this.email = email;
		this.descSetor = descSetor;
	}
	
	public static ColaboradorDTO converter(Optional<Colaborador> colaborador) {
		ColaboradorDTO dto = new ColaboradorDTO();
		
		if(!colaborador.isPresent())
			return dto;
		
		dto.nome = colaborador.get().getNome();
		dto.email = colaborador.get().getEmail();
		dto.descSetor = colaborador.get().getSetor().getDescricao();
		
		return dto;
	}
	
}
