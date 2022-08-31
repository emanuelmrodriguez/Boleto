package com.empresa.boleto.service;

import com.empresa.boleto.model.Boleto;
import com.empresa.boleto.repository.BoletoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {

    private final BoletoRepository boletoRepository;

    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public Boleto getBoletoById(Long id) throws ChangeSetPersister.NotFoundException {
        try {
            return boletoRepository.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Boleto nao enconrado");
        }
    }


    public List<Boleto> getAll() {
        try {
            return boletoRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Optional<Boleto> getByDate(Date dataEmicao) throws Exception {
        Optional<Boleto> boletos = boletoRepository.findByDataEmicao(dataEmicao);
        if (boletos.isPresent()) {
            return boletos;
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
