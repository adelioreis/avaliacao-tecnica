package br.com.softplan.teste;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.softplan.teste.model.bo.CalculoBO;
import br.com.softplan.teste.model.dto.ParametrosDTO;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TesteApplication.class)
@SpringBootTest
public class SuiteApplicationTest {

	@Autowired
	CalculoBO calculoBO;

	@Test
	public void contextLoads() {
	}

	@Test
	public void calcularCarga4() {
		ParametrosDTO parametrosDTO = new ParametrosDTO();
		parametrosDTO.setDistanciaRodoviaNaoPavimentada(BigDecimal.valueOf(60));
		parametrosDTO.setCarga(4);
		parametrosDTO.setFatorMultiplicadorCusto(BigDecimal.valueOf(1.00));

		Assert.assertEquals(BigDecimal.valueOf(37.20).setScale(2, RoundingMode.DOWN), calculoBO.calcularValor(parametrosDTO));
	}

	@Test
	public void calcularCarga5() {
		ParametrosDTO parametrosDTO = new ParametrosDTO();
		parametrosDTO.setDistanciaRodoviaPavimentada(BigDecimal.valueOf(50));
		parametrosDTO.setDistanciaRodoviaNaoPavimentada(BigDecimal.valueOf(30));
		parametrosDTO.setCarga(5);
		parametrosDTO.setFatorMultiplicadorCusto(BigDecimal.valueOf(1.05));
		Assert.assertEquals(BigDecimal.valueOf(47.88), calculoBO.calcularValor(parametrosDTO));
	}

	@Test
	public void calcularCarga6() {
		ParametrosDTO parametrosDTO = new ParametrosDTO();
		parametrosDTO.setDistanciaRodoviaPavimentada(BigDecimal.valueOf(80));
		parametrosDTO.setDistanciaRodoviaNaoPavimentada(BigDecimal.valueOf(20));
		parametrosDTO.setCarga(6);
		parametrosDTO.setFatorMultiplicadorCusto(BigDecimal.valueOf(1.00));
		Assert.assertEquals(BigDecimal.valueOf(57.6).setScale(2, RoundingMode.DOWN), calculoBO.calcularValor(parametrosDTO));
	}

	@Test
	public void calcularCarga8() {
		ParametrosDTO parametrosDTO = new ParametrosDTO();
		parametrosDTO.setDistanciaRodoviaPavimentada(BigDecimal.valueOf(100));
		parametrosDTO.setCarga(8);
		parametrosDTO.setFatorMultiplicadorCusto(BigDecimal.valueOf(1.05));
		Assert.assertEquals(BigDecimal.valueOf(62.70).setScale(2, RoundingMode.DOWN), calculoBO.calcularValor(parametrosDTO));
	}

	@Test
	public void calcularCarga12() {
		ParametrosDTO parametrosDTO = new ParametrosDTO();
		parametrosDTO.setDistanciaRodoviaNaoPavimentada(BigDecimal.valueOf(180));
		parametrosDTO.setCarga(12);
		parametrosDTO.setFatorMultiplicadorCusto(BigDecimal.valueOf(1.12));
		Assert.assertEquals(BigDecimal.valueOf(150.19), calculoBO.calcularValor(parametrosDTO));
	}

	@Test
	public void calcularSemValores() {
		ParametrosDTO parametrosDTO = new ParametrosDTO();
		Assert.assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.DOWN), calculoBO.calcularValor(parametrosDTO));
	}

	@Test
	public void calcularNull() {
		Assert.assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.DOWN), calculoBO.calcularValor(null));
	}

}
