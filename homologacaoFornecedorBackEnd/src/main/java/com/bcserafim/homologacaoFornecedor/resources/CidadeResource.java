package com.bcserafim.homologacaoFornecedor.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcserafim.homologacaoFornecedor.entities.Cidade;
import com.bcserafim.homologacaoFornecedor.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
	
	@Autowired
	private  CidadeService service;
	
	
	@GetMapping
	public ResponseEntity<List<Cidade>> findALL() {
		List<Cidade> list = service.findALL();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Cidade obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Cidade> insert(@RequestBody Cidade obj) {
		Cidade novaCidade = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaCidade.getId()).toUri();
		return ResponseEntity.created(uri).body(novaCidade);
	}
	
	 @DeleteMapping(value = "/{id}")
	 public ResponseEntity<Void> delete(@PathVariable Long id) {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	 }
	 
	 @PutMapping(value = "/{id}")
	 public ResponseEntity<Cidade> update(@PathVariable Long id, @RequestBody Cidade obj ) {
		 obj = service.update(id, obj);
		 return ResponseEntity.ok().body(obj);
	 }
	
	
	
	
	
}
