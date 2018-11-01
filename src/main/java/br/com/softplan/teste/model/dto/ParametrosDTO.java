package br.com.softplan.teste.model.dto;

import java.math.BigDecimal;

public class ParametrosDTO {
    private BigDecimal distanciaRodoviaPavimentada;
    private BigDecimal distanciaRodoviaNaoPavimentada;
    private BigDecimal fatorMultiplicadorCusto;
    private int carga;
    private Long idVeiculo;

    public BigDecimal getDistanciaRodoviaPavimentada() {
        return distanciaRodoviaPavimentada;
    }

    public void setDistanciaRodoviaPavimentada(BigDecimal distanciaRodoviaPavimentada) {
        this.distanciaRodoviaPavimentada = distanciaRodoviaPavimentada;
    }

    public BigDecimal getDistanciaRodoviaNaoPavimentada() {
        return distanciaRodoviaNaoPavimentada;
    }

    public void setDistanciaRodoviaNaoPavimentada(BigDecimal distanciaRodoviaNaoPavimentada) {
        this.distanciaRodoviaNaoPavimentada = distanciaRodoviaNaoPavimentada;
    }

    public BigDecimal getFatorMultiplicadorCusto() {
        return fatorMultiplicadorCusto;
    }

    public void setFatorMultiplicadorCusto(BigDecimal fatorMultiplicadorCusto) {
        this.fatorMultiplicadorCusto = fatorMultiplicadorCusto;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}
