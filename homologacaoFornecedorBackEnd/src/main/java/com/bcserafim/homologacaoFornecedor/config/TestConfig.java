package com.bcserafim.homologacaoFornecedor.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bcserafim.homologacaoFornecedor.entities.Cidade;
import com.bcserafim.homologacaoFornecedor.entities.Empresa;
import com.bcserafim.homologacaoFornecedor.entities.Endereco;
import com.bcserafim.homologacaoFornecedor.entities.Estado;
import com.bcserafim.homologacaoFornecedor.entities.Login;
import com.bcserafim.homologacaoFornecedor.entities.Pais;
import com.bcserafim.homologacaoFornecedor.entities.enums.RegimeTributario;
import com.bcserafim.homologacaoFornecedor.repositories.CidadeRepository;
import com.bcserafim.homologacaoFornecedor.repositories.EmpresaRepository;
import com.bcserafim.homologacaoFornecedor.repositories.EnderecoRepository;
import com.bcserafim.homologacaoFornecedor.repositories.EstadoRepository;
import com.bcserafim.homologacaoFornecedor.repositories.LoginRepository;
import com.bcserafim.homologacaoFornecedor.repositories.PaisRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pais p1 = new Pais(null, "Brasil");
		
		paisRepository.saveAll(Arrays.asList(p1));
		
		Estado e1  = new Estado(null, "Acre", "AC", p1 );
		Estado e2  = new Estado(null, "Alagoas", "AL", p1 );
		Estado e3  = new Estado(null, "Amapa", "AP", p1 );
		Estado e4  = new Estado(null, "Amazonas", "AM", p1 );
		Estado e5  = new Estado(null, "Bahia", "BA", p1 );
		Estado e6  = new Estado(null, "Ceara", "CE", p1 );
		Estado e7  = new Estado(null, "Espirito Santo", "ES", p1 );
		Estado e8  = new Estado(null, "Goias", "GO", p1 );
		Estado e9  = new Estado(null, "Maranhao", "MA", p1 );
		Estado e10 = new Estado(null, "Mato Grosso", "MT", p1 );
		Estado e11 = new Estado(null, "Mato Grosso do Sul", "MS", p1 );
		Estado e12 = new Estado(null, "Minas Gerais", "MG", p1 );
		Estado e13 = new Estado(null, "Para", "PA", p1 );
		Estado e14 = new Estado(null, "Paraiba", "PB", p1 );
		Estado e15 = new Estado(null, "Parana", "PR", p1 );
		Estado e16 = new Estado(null, "Pernambuco", "PE", p1 );
		Estado e17 = new Estado(null, "Piaui", "PI", p1 );
		Estado e18 = new Estado(null, "Rio de Janeiro", "RJ", p1 );
		Estado e19 = new Estado(null, "Rio Grande do Norte", "RN", p1 );
		Estado e20 = new Estado(null, "Rio Grande do Sul", "RS", p1 );
		Estado e21 = new Estado(null, "Rondonia", "RO", p1 );
		Estado e22 = new Estado(null, "Roraima", "RR", p1 );
		Estado e23 = new Estado(null, "Santa Catarina", "SC", p1 );
		Estado e24 = new Estado(null, "Sao Paulo", "SP", p1 );
		Estado e25 = new Estado(null, "Sergipe", "SE", p1 );
		Estado e26 = new Estado(null, "Tocantins", "TO", p1 );
		Estado e27 = new Estado(null, "Distrito Federal", "DF", p1 );
	 			
		
		estadoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8,
				e9, e10, e11, e12, e13,  e14, e15, e16, e17, e18, e19, e20,
				e21, e22, e23, e24, e25, e26, e27));
		
		Cidade c1 = new Cidade(null, "Rio Branco", e1);
		Cidade c2 = new Cidade(null, "Maceio", e2);
		Cidade c3 = new Cidade(null, "Macapa", e3);
		Cidade c4 = new Cidade(null, "Manaus", e4);
		Cidade c5 = new Cidade(null, "Salvador", e5);
		Cidade c6 = new Cidade(null, "Fortaleza", e6);
		Cidade c7 = new Cidade(null, "Vitoria", e7);
		Cidade c8 = new Cidade(null, "Goiania", e8);
		Cidade c9 = new Cidade(null, "Sao Luis", e9);
		Cidade c10 = new Cidade(null, "Cuiaba", e10);
		Cidade c11 = new Cidade(null, "Campo Grande", e11);
		Cidade c12 = new Cidade(null, "Belo Horizonte", e12);
		Cidade c13 = new Cidade(null, "Belem", e13);
		Cidade c14 = new Cidade(null, "Joao Pessoa", e14);
		Cidade c15 = new Cidade(null, "Curitiba", e15);
		Cidade c16 = new Cidade(null, "Recife", e16);
		Cidade c17 = new Cidade(null, "Teresina", e17);
		Cidade c18 = new Cidade(null, "Rio de Janeiro", e18);
		Cidade c19 = new Cidade(null, "Natal", e19);
		Cidade c20 = new Cidade(null, "Porto Alegre", e20);
		Cidade c21 = new Cidade(null, "Porto Velho", e21);
		Cidade c22 = new Cidade(null, "Boa Vista", e22);
		Cidade c23 = new Cidade(null, "Florianopolis", e23);
		Cidade c24 = new Cidade(null, "Sao Paulo", e24);
		Cidade c25 = new Cidade(null, "Aracaju", e25);
		Cidade c26 = new Cidade(null, "Palmas", e26);
		Cidade c27 = new Cidade(null, "Brasília", e27);
				
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9,
				c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21,  c22, 
				c23, c24, c25, c26, c27));
		
		
	Endereco end1 = new Endereco(null,"Rua teste", 45, "B22", "Sitio Cercado",c15);
		c15.setEndereco(end1);		
		enderecoRepository.saveAll(Arrays.asList(end1));
		
	
	Login log1 = new Login(null, "emailTeste@gmail.com", "0123456");
			
	Empresa emp1 = new Empresa(null, "Nome Teste", "Nome Fantasia Teste", "54.021.422/0001-72", "IE123", "IM123", 70, RegimeTributario.LUCRO_REAL, end1);
			
		// Associe Login e Empresa
		log1.setEmpresa(emp1);
		emp1.setLogin(log1);
		
		 // Salve Login e Empresa
		loginRepository.saveAll(Arrays.asList(log1));
		empresaRepository.saveAll(Arrays.asList(emp1));
	}	
}
