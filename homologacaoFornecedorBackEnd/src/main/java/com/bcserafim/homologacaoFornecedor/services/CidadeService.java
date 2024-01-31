package com.bcserafim.homologacaoFornecedor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bcserafim.homologacaoFornecedor.entities.Cidade;
import com.bcserafim.homologacaoFornecedor.repositories.CidadeRepository;
import com.bcserafim.homologacaoFornecedor.services.exceptions.DatabaseException;
import com.bcserafim.homologacaoFornecedor.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	
	public List<Cidade> findALL() {
		return repository.findAll();
	}
	
	public Cidade findById(Long id) {
		Optional<Cidade> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cidade insert(Cidade obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
	}
	
	public Cidade update(Long id, Cidade obj) {
		try {
			Cidade entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Cidade entity, Cidade obj) {
		entity.setCidade(obj.getCidade());
		
	}
	

}
