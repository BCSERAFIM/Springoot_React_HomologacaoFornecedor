package com.bcserafim.homologacaoFornecedor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bcserafim.homologacaoFornecedor.entities.Pais;
import com.bcserafim.homologacaoFornecedor.repositories.PaisRepository;
import com.bcserafim.homologacaoFornecedor.services.exceptions.DatabaseException;
import com.bcserafim.homologacaoFornecedor.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaisService {

	@Autowired
	private PaisRepository repository;
	
	
	public List<Pais> findALL() {
		return repository.findAll();
	}
	
	public Pais findById(Long id) {
		Optional<Pais> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Pais insert(Pais obj) {
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
	
	public Pais update(Long id, Pais obj) {
		try {
			Pais entity = repository.getReferenceById(id);
			updateData(entity, obj );
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Pais entity, Pais obj) {
		entity.setPais(obj.getPais());
		
		
	}
	
	
	
}
