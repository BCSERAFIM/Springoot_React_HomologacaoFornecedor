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
import com.bcserafim.homologacaoFornecedor.entities.Endereco;
import com.bcserafim.homologacaoFornecedor.services.CidadeService;
import com.bcserafim.homologacaoFornecedor.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
	
	@Autowired
	private  EnderecoService enderecoService;
	
	  @Autowired
	   private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findALL() {
		List<Endereco> list = enderecoService.findALL();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Endereco obj = enderecoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Endereco> insert(@RequestBody Endereco obj) {		
		
		Cidade cidade = obj.getCidade();		
		cidade = cidadeService.insert(cidade);	
		obj.setCidade(cidade);		
		obj = enderecoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	 @DeleteMapping(value = "/{id}")
	 public ResponseEntity<Void> delete(@PathVariable Long id) {
		 enderecoService.delete(id);
		 return ResponseEntity.noContent().build();
	 }
	 
	 @PutMapping(value = "/{id}")
	 public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco obj ) {
		 obj = enderecoService.update(id, obj);
		 return ResponseEntity.ok().body(obj);
	 }
	
}
