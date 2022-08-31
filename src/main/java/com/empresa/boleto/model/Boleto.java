package com.empresa.boleto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "boleto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boleto {

    @Id
    public Long idBoleto;
    public Integer numeroConta;
    public String nomeCliente;
    public String banco;
    public String linhaDigitavel;
    public String nomeEmpresa;
    public Date dataEmicao;
    public Date dataVencimento;
    public BigDecimal valor;
    public String moeda;

}
