package com.bcserafim.homologacaoFornecedor.entities;

import java.io.Serializable;
import java.util.Objects;

import com.bcserafim.homologacaoFornecedor.entities.enums.RegimeTributario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nomeFantasia;
	private String cnpj;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private int score;
	
	@OneToOne
	@JoinColumn(name = "login_id")
	private Login login;

	@OneToOne
	@JoinColumn(name = "endereco_id")	
	private Endereco endereco;
	
	
	private Integer regimeTributario;
	
	
	public Empresa() {
		
	}

	public Empresa(Long id, String nome, String nomeFantasia, String cnpj, String inscricaoEstadual,
			String inscricaoMunicipal, int score, RegimeTributario regimeTributario, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.score = score;
		setRegimeTributario(regimeTributario);
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	

	public RegimeTributario getRegimeTributario() {
		return RegimeTributario.valueOF(regimeTributario);
	}

	public void setRegimeTributario(RegimeTributario regimeTributario) {
		if(regimeTributario != null) {
			this.regimeTributario = regimeTributario.getCode();
		}		
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}

	
}
