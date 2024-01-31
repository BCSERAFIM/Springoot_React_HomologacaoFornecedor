package com.bcserafim.homologacaoFornecedor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bcserafim.homologacaoFornecedor.entities.Empresa;
import com.bcserafim.homologacaoFornecedor.repositories.EmpresaRepository;
import com.bcserafim.homologacaoFornecedor.services.exceptions.DatabaseException;
import com.bcserafim.homologacaoFornecedor.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	
	public List<Empresa> findALL() {
		return repository.findAll();
	}
	
	public Empresa findById(Long id) {
		Optional<Empresa> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Empresa insert(Empresa obj) {
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
	
	public Empresa update(Long id, Empresa obj) {
		try {
			Empresa entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Empresa entity, Empresa obj) {
		entity.setNomeFantasia(obj.getNomeFantasia());
		entity.setScore(obj.getScore());
		entity.setRegimeTributario(obj.getRegimeTributario());
	}
	
	
}
