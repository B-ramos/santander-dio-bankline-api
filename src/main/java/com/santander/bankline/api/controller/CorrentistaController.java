package com.santander.bankline.api.controller;

import com.santander.bankline.api.dto.NovoCorrentistaDto;
import com.santander.bankline.api.model.Correntista;
import com.santander.bankline.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaService correntistaService;

    @GetMapping
    public List<Correntista> findAll() {
        return correntistaService.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentistaDto novoCorrentistaDto) {
        correntistaService.save(novoCorrentistaDto);
    }
}