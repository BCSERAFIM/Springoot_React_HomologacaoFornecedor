package com.bcserafim.homologacaoFornecedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcserafim.homologacaoFornecedor.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
