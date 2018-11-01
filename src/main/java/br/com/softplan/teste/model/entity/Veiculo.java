package br.com.softplan.teste.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private @Size(min = 4, max=255) String descricao;
    @Column(name = "fator_multiplicador")
    private BigDecimal fatorMultiplicador;
    @Column(name = "data_cadastro")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getFatorMultiplicador() {
        return fatorMultiplicador;
    }

    public void setFatorMultiplicador(BigDecimal fatorMultiplicador) {
        this.fatorMultiplicador = fatorMultiplicador;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
