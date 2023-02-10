package com.gabriel.demomvc.service;

import com.gabriel.demomvc.domain.Funcionario;

import java.util.List;

public interface FuncionarioService {

    void salvar(Funcionario funcionario);
    void editar(Funcionario funcionario);
    void excluir(Long id);
    Funcionario buscarPorId(Long id);
    List<Funcionario> buscarTodos();
    List<Funcionario> buscarPorNomes(String nome);
    List<Funcionario> buscarPorCargos(Long id);
}
