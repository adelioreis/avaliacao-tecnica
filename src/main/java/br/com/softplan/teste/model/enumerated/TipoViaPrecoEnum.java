package br.com.softplan.teste.model.enumerated;

import java.math.BigDecimal;

public enum TipoViaPrecoEnum {
    PAVIMENTADA(BigDecimal.valueOf(0.54)),
    NAO_PAVIMENTADA(BigDecimal.valueOf(0.62));

    private final BigDecimal valor;

    TipoViaPrecoEnum(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
