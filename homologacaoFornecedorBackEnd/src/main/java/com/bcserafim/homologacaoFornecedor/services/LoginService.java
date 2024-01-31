package com.bcserafim.homologacaoFornecedor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bcserafim.homologacaoFornecedor.entities.Login;
import com.bcserafim.homologacaoFornecedor.repositories.LoginRepository;
import com.bcserafim.homologacaoFornecedor.services.exceptions.DatabaseException;
import com.bcserafim.homologacaoFornecedor.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repository;
	
	
	public List<Login> findALL() {
		return repository.findAll();
	}
	
	public Login findById(Long id) {
		Optional<Login> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Login insert(Login obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} catch (RuntimeException e ) {
			e.printStackTrace();
		}
		
	}
	
	public Login update(Long id, Login obj) {
		try {
			Login entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Login entity, Login obj) {
		entity.setEmail(obj.getEmail());		
	}
	
}
