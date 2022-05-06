package com.santander.bankline.api.service;

import com.santander.bankline.api.dto.NovaMovimentacaoDto;
import com.santander.bankline.api.model.Correntista;
import com.santander.bankline.api.model.Movimentacao;
import com.santander.bankline.api.model.MovimentacaoTipo;
import com.santander.bankline.api.repository.CorrentistaRepository;
import com.santander.bankline.api.repository.MovimentecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentecaoRepository movimentecaoRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public List<Movimentacao> finAll(){
        var a = movimentecaoRepository.findAll();

        return a;
    }

    public void save(NovaMovimentacaoDto novaMovimentacao) {
        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ?
                novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setValor(valor);
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        movimentecaoRepository.save(movimentacao);
    }
}
