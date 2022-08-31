package com.empresa.boleto.repository;

import com.empresa.boleto.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long> {
    Optional<Boleto> findByDataEmicao(Date date);

}
