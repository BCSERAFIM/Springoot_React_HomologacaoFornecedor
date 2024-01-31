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

import com.bcserafim.homologacaoFornecedor.entities.Login;
import com.bcserafim.homologacaoFornecedor.services.LoginService;

@RestController
@RequestMapping(value = "/login")
public class LoginResource {
	
	@Autowired
	private  LoginService service;
	
	
	@GetMapping
	public ResponseEntity<List<Login>> findALL() {
		List<Login> list = service.findALL();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Login> findById(@PathVariable Long id) {
		Login obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Login> insert (@RequestBody Login obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	 @DeleteMapping(value = "/{id}")
	 public ResponseEntity<Void> delete(@PathVariable Long id) {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	 }
	 
	 @PutMapping(value = "/{id}")
	 public ResponseEntity<Login> update(@PathVariable Long id, @RequestBody Login obj ) {
		 obj = service.update(id, obj);
		 return ResponseEntity.ok().body(obj);
	 }
	
}
