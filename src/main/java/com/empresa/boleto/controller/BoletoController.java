package com.empresa.boleto.controller;

import com.empresa.boleto.model.Boleto;
import com.empresa.boleto.service.BoletoService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boleto")
public class BoletoController {

    private final BoletoService boletoService;

    public BoletoController(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleto> getById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(boletoService.getBoletoById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Boleto>> getAll(){
        return ResponseEntity.ok(boletoService.getAll());
    }

    @GetMapping("/date")
    public ResponseEntity<Optional<Boleto>> finByDate(Date dataEmicao) throws Exception {
        return ResponseEntity.ok(boletoService.getByDate(dataEmicao));
    }
}
