package com.santander.bankline.api.controller;

import com.santander.bankline.api.dto.NovaMovimentacaoDto;
import com.santander.bankline.api.model.Movimentacao;
import com.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")

public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> findAll() {
        return movimentacaoService.finAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findById(@PathVariable("idConta") Integer idConta){
        return movimentacaoService.findByIdConta(idConta);
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacaoDto novaMovimentacao) {
        movimentacaoService.save(novaMovimentacao);
    }
}
