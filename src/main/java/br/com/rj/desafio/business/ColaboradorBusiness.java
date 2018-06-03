package br.com.rj.desafio.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rj.desafio.dao.ColaboradorDao;
import br.com.rj.desafio.dto.ColaboradorDTO;
import br.com.rj.desafio.entity.Colaborador;

@Service(value="colaboradorBusiness")
public class ColaboradorBusiness implements IColaboradorBusiness{

	@Autowired
	private ColaboradorDao dao;
	
	@Override
	public ColaboradorDTO buscarPorId(Long id) {
		return ColaboradorDTO.converter(dao.findById(id));
	}

	@Override
	public void remover(Long id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public void inserir(Colaborador colaborador) {
		dao.save(colaborador);
	}

	@Override
	public List<ColaboradorDTO> listar() {
		return dao.listar();
	}
	
}
