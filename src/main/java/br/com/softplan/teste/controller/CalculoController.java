package br.com.softplan.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.softplan.teste.model.bo.CalculoBO;
import br.com.softplan.teste.model.dto.ParametrosDTO;
import br.com.softplan.teste.model.repository.VeiculoRepository;

@Controller
public class CalculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CalculoBO calculoBO;

    @RequestMapping("custo-transporte")
    public String exibirTelaCustoTransporte(final Model model) {
        model.addAttribute("parametros", new ParametrosDTO());
        model.addAttribute("veiculos", veiculoRepository.findAll());
        return "calcular-custo-transporte";
    }

    @RequestMapping(value="calcular-custo-transporte", method=RequestMethod.POST)
    public String calcularCustoTransporte(final ParametrosDTO parametrosDTO, final Model model) {
        model.addAttribute("parametros", parametrosDTO);
        model.addAttribute("veiculos", veiculoRepository.findAll());
        model.addAttribute("resultado", calculoBO.calcularValor(parametrosDTO));
        return "calcular-custo-transporte";
    }
}
