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

import com.bcserafim.homologacaoFornecedor.entities.Empresa;
import com.bcserafim.homologacaoFornecedor.services.EmpresaService;
import com.bcserafim.homologacaoFornecedor.services.EnderecoService;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaResource {
	
	@Autowired
	private  EmpresaService empresaService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<Empresa>> findALL() {
		List<Empresa> list = empresaService.findALL();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable Long id) {
		Empresa obj = empresaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Empresa> insert(@RequestBody Empresa obj) {
		if (obj.getEndereco() != null && obj.getEndereco().getId() == null) {
			obj.setEndereco(enderecoService.insert(obj.getEndereco()));
		}
		obj = empresaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	 @DeleteMapping(value = "/{id}")
	 public ResponseEntity<Void> delete(@PathVariable Long id) {
		 empresaService.delete(id);
		 return ResponseEntity.noContent().build();
	 }
	 
	 @PutMapping(value = "/{id}")
	 public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa obj ) {
		 obj = empresaService.update(id, obj);
		 return ResponseEntity.ok().body(obj);
	 }
	
	
	
	
	
	
}
