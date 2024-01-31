package com.bcserafim.homologacaoFornecedor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.bcserafim.homologacaoFornecedor.entities.Endereco;
import com.bcserafim.homologacaoFornecedor.repositories.EnderecoRepository;
import com.bcserafim.homologacaoFornecedor.services.exceptions.DatabaseException;
import com.bcserafim.homologacaoFornecedor.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	
	public List<Endereco> findALL() {
		return repository.findAll();
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Endereco insert(Endereco obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Endereco update(Long id, Endereco obj) {
		try {
			Endereco entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
		
	}

	private void updateData(Endereco entity, Endereco obj) {
		entity.setLogradouro(obj.getLogradouro());
		entity.setNumero(obj.getNumero());
		entity.setComplemento(obj.getComplemento());
		entity.setBairro(obj.getBairro());		
	}
	 
	 
	
}
