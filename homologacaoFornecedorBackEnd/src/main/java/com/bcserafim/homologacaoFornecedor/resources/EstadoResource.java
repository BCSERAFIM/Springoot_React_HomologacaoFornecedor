package com.bcserafim.homologacaoFornecedor.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bcserafim.homologacaoFornecedor.entities.Estado;
import com.bcserafim.homologacaoFornecedor.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private  EstadoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Estado>> findALL() {
		List<Estado> list = service.findALL();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> findById(@PathVariable Long id) {
		Estado obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Estado> insert(@RequestBody Estado obj) {
		Estado novoEstado = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoEstado.getId()).toUri();
		return ResponseEntity.created(uri).body(novoEstado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	 @PutMapping(value = "/{id}")
	 public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody Estado obj) {
		 obj = service.update(id, obj);
		 return ResponseEntity.ok().body(obj);
	 }
	
	
	
	
	
}
