package com.santander.bankline.api.repository;

import com.santander.bankline.api.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovintecaoRepository extends JpaRepository<Movimentacao, Integer> {
}
