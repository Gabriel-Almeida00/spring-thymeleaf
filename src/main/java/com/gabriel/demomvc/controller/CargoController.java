package com.gabriel.demomvc.controller;

import com.gabriel.demomvc.domain.Cargo;
import com.gabriel.demomvc.domain.Departamento;
import com.gabriel.demomvc.service.CargoService;
import com.gabriel.demomvc.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo){
        return "/cargo/cadastro";
    }
    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr){
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success","Cargo inserido com sucesso");
        return "redirect:/cargos/cadastrar";
    }
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cargo",cargoService.buscarPorId(id));
        return "cargo/cadastro";
    }
    @PostMapping("/editar")
    public String editar(Cargo cargo, RedirectAttributes attr){
        cargoService.editar(cargo);
        attr.addFlashAttribute("success","Registro atualizado com sucesso.");
        return "redirect:/cargos/cadastrar";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        if(cargoService.cargoTemFuncionario(id)){
            attr.addFlashAttribute("fail", "Cargo nâo excluido tem funcionáros vinculados");
        } else{
            cargoService.excluir(id);
            attr.addFlashAttribute("success","Cargo excluido com sucesso");
        }
        return "redirect:/cargos/listar";
    }
    @ModelAttribute("departamentos")
    public List<Departamento> listaDepartamentos(){
        return departamentoService.buscarTodos();
    }
}
