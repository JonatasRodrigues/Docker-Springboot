package br.com.rj.desafio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.rj.desafio.dto.ColaboradorDTO;
import br.com.rj.desafio.entity.Colaborador;

@Repository
public interface ColaboradorDao extends JpaRepository<Colaborador,Long>{

	@Query(value=" select new br.com.rj.desafio.dto.ColaboradorDTO (c.nome, c.email,s.descricao) from Colaborador c"
			+ " inner join c.setor s "
			+ " where 1=1 group by s.descricao, c.nome, c.email order by s.descricao asc")
	List<ColaboradorDTO> listar();
}
