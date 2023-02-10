package com.gabriel.demomvc.controller;


import com.gabriel.demomvc.domain.Cargo;
import com.gabriel.demomvc.domain.Funcionario;
import com.gabriel.demomvc.domain.UF;
import com.gabriel.demomvc.service.CargoService;
import com.gabriel.demomvc.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario){
        return "/funcionario/cadastro";
    }
    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("funcionarios",funcionarioService.buscarTodos());
        return "/funcionario/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr){
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success","Funcionário inserido com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("funcionario",funcionarioService.buscarPorId(id));
        return "funcionario/cadastro";
    }
    @PostMapping("/editar")
    public String editar(Funcionario funcionario, RedirectAttributes attr){
        funcionarioService.editar(funcionario);
        attr.addFlashAttribute("success","Funcionário edtado com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        funcionarioService.excluir(id);
        attr.addFlashAttribute("success","Funconário removido com sucesso");
        return "redirect:/funcionarios/listar";
    }
    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarPorNomes(nome));
        return "/funcionario/lista";
    }
    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarPorCargos(id));
        return "funcionario/lista";
    }
    @ModelAttribute("cargos")
    public List<Cargo> getCargos(){
        return cargoService.buscarTodos();
    }
    @ModelAttribute("ufs")
    public UF[] getUFs(){
        return UF.values();
    }
}
