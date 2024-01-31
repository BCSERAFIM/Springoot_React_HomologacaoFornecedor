package com.bcserafim.homologacaoFornecedor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bcserafim.homologacaoFornecedor.entities.Estado;
import com.bcserafim.homologacaoFornecedor.repositories.EstadoRepository;
import com.bcserafim.homologacaoFornecedor.services.exceptions.DatabaseException;
import com.bcserafim.homologacaoFornecedor.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	
	public List<Estado> findALL() {
		return repository.findAll();
	}
	
	public Estado findById(Long id) {
		Optional<Estado> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Estado insert(Estado obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			//throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} catch (RuntimeException e ) {
			e.printStackTrace();
		}
		
	}
	
	public Estado update(Long id, Estado obj) {
		try {
			Estado entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
				
	}

	private void updateData(Estado entity, Estado obj) {
		entity.setEstado(obj.getEstado());
		entity.setEstado(obj.getSigla());
		
	}
	
}
