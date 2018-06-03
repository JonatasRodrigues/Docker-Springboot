package br.com.rj.desafio.controller;

import static br.com.rj.desafio.constantes.ApplicationConstant.MSG_200;
import static br.com.rj.desafio.constantes.ApplicationConstant.MSG_201;
import static br.com.rj.desafio.constantes.ApplicationConstant.MSG_400;
import static br.com.rj.desafio.constantes.ApplicationConstant.MSG_404;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rj.desafio.business.IColaboradorBusiness;
import br.com.rj.desafio.config.MensagemResource;
import br.com.rj.desafio.dto.ColaboradorDTO;
import br.com.rj.desafio.entity.Colaborador;
import br.com.rj.desafio.exception.RecursoNotFoundException;
import br.com.rj.desafio.exception.RequisicaoInvalidaException;

@RestController
@RequestMapping("/api")
public class ColaboradorController {

	 private static final Logger logger = LogManager.getLogger(ColaboradorController.class);
	 
	 @Autowired
	 private IColaboradorBusiness business;
	 
	 
	 @RequestMapping(method = RequestMethod.POST, path = "/colaborador/create")
	    public ResponseEntity<String> criar(@RequestBody Colaborador colaborador) {
		 
		 try {
			 business.inserir(colaborador);
		        logger.info(MensagemResource.getMensagem(MSG_201));
		        return new ResponseEntity<>(MensagemResource.getMensagem(MSG_201),
		                HttpStatus.CREATED);
		 }catch(Exception e) {
			 logger.error("Erro ao salvar registro." + e.getMessage());
		 }
		 	return null;
		 	
	    }

	    @RequestMapping(method = RequestMethod.GET, path = "/colaborador/list")
	    public ResponseEntity<Iterable> listar() {
	        Iterable<ColaboradorDTO> all = business.listar();
	        logger.info(MensagemResource.getMensagem(MSG_200));
	        return new ResponseEntity<>(all, HttpStatus.OK);
	    }


	    @RequestMapping(method = RequestMethod.GET, path = "/colaborador/{id}")
	    public ResponseEntity<ColaboradorDTO> buscarPorId(@PathVariable final Long id) {
	    	
	    	if(id==null)
	    		throw new RequisicaoInvalidaException(MensagemResource.getMensagem(MSG_400));
	    	
	    	ColaboradorDTO colaborador = business.buscarPorId(id);
	        
	        if(colaborador==null)
	        	throw new RecursoNotFoundException(MensagemResource.getMensagem(MSG_404));
	        	
	            logger.info(MensagemResource.getMensagem(MSG_200));
	            return new ResponseEntity<>(colaborador, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.DELETE, path = "/colaborador/{id}/delete")
	    public ResponseEntity<String> deletar(@PathVariable final Long id) {
	    	
	    	if(id==null)
	    		throw new RequisicaoInvalidaException(MensagemResource.getMensagem(MSG_400));
	    	
	            business.remover(id);
	            logger.info(MensagemResource.getMensagem(MSG_200));
	            return new ResponseEntity<>(MensagemResource.getMensagem(MSG_200), HttpStatus.OK);
	    }
	 
}
