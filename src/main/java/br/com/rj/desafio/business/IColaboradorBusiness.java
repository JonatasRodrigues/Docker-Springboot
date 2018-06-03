package br.com.rj.desafio.business;

import java.util.List;

import br.com.rj.desafio.dto.ColaboradorDTO;
import br.com.rj.desafio.entity.Colaborador;

public interface IColaboradorBusiness {

	ColaboradorDTO buscarPorId(Long id);

	void remover(Long id);

	void inserir(Colaborador colaborador);

	List<ColaboradorDTO> listar();

}
