package br.com.softplan.teste.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.softplan.teste.model.entity.Veiculo;
import br.com.softplan.teste.model.repository.VeiculoRepository;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoRepository repository;

    @RequestMapping()
    public String listarVeiculos(final Model model) {
        model.addAttribute("veiculos", repository.findAll());
        return "veiculo-lista";
    }

    @RequestMapping("/cadastro")
    public String visualizar(final @Valid Veiculo veiculo, final BindingResult result, final Model model) {
        return "veiculo-cadastro";
    }

    @RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable final Long id, final Model model) {
        final Veiculo veiculo = repository.findById(id)
                .orElse(new Veiculo());

        model.addAttribute("veiculo", veiculo);
        return "veiculo-cadastro";
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String gravar(final @Valid Veiculo veiculo, final BindingResult result, final Model model) {
        String view = "redirect:/veiculos";
        if(result.hasFieldErrors("*")) {
            model.addAttribute("veiculo", veiculo);
            view = "veiculo-cadastro";
        } else {
            if (veiculo.getId() == null) {
                LocalDate dataCadastro = LocalDate.now();
                veiculo.setDataCadastro(dataCadastro);
            }

            repository.save(veiculo);
        }
        return view;
    }

    @RequestMapping(value="/apagar/{id}", method = RequestMethod.GET)
    public String apagar(@PathVariable final Long id) {
        repository.deleteById(id);
        return "redirect:/veiculos";
    }

}
