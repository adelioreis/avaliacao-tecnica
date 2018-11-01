package br.com.softplan.teste.model.bo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import br.com.softplan.teste.model.dto.ParametrosDTO;
import br.com.softplan.teste.model.enumerated.TipoViaPrecoEnum;

@Component
public class CalculoBO {

    /**
     * Efetua o cálculo de valor de transporte, baseado nos parâmetros informados.
     *
     * @param parametrosDTO, parâmetros necessários para o cálculo.
     * @return valor do Transporte Calculado.
     */
    public BigDecimal calcularValor(final ParametrosDTO parametrosDTO) {

        BigDecimal retorno = BigDecimal.ZERO;

        if (parametrosDTO != null) {

            BigDecimal totalKmRodado = BigDecimal.ZERO;

            if (parametrosDTO.getDistanciaRodoviaPavimentada() != null) {
                retorno = retorno.add(parametrosDTO.getDistanciaRodoviaPavimentada().multiply(TipoViaPrecoEnum.PAVIMENTADA.getValor()));
                totalKmRodado = totalKmRodado.add(parametrosDTO.getDistanciaRodoviaPavimentada());
            }

            if (parametrosDTO.getDistanciaRodoviaNaoPavimentada() != null) {
                retorno =
                        retorno.add(
                                parametrosDTO.getDistanciaRodoviaNaoPavimentada().multiply(TipoViaPrecoEnum.NAO_PAVIMENTADA.getValor()));
                totalKmRodado = totalKmRodado.add(parametrosDTO.getDistanciaRodoviaNaoPavimentada());
            }

            if (parametrosDTO.getFatorMultiplicadorCusto() != null) {
                retorno = retorno.multiply(parametrosDTO.getFatorMultiplicadorCusto());
            }

            if (parametrosDTO.getCarga() > 5) {
                retorno = retorno.add(calcularValorExcedente(parametrosDTO.getCarga(), totalKmRodado));
            }
        }

        retorno = retorno.setScale(2, RoundingMode.DOWN);

        return retorno;
    }

    /**
     * Calcula o valor excedente para cargas acima de 5 Toneladas.
     *
     * @param carga, valor em toneladas.
     * @param totalKmRodado, total de Km percorrido somando os trajetos por Rodovia Pavimentada e Não Pavimentada.
     * @return valor excede a ser adicionado ao valor do transporte.
     */
    private BigDecimal calcularValorExcedente(final int carga, final BigDecimal totalKmRodado) {
        BigDecimal retorno = BigDecimal.ZERO;
        int cargaExcedente = carga - 5;
        BigDecimal valorExcedentePorKm = BigDecimal.valueOf(cargaExcedente).multiply(BigDecimal.valueOf(0.02));
        return totalKmRodado.multiply(valorExcedentePorKm);
    }

}
