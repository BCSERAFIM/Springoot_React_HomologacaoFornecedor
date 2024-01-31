package com.bcserafim.homologacaoFornecedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcserafim.homologacaoFornecedor.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
