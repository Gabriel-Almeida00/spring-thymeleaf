package com.gabriel.demomvc.service;

import com.gabriel.demomvc.domain.Cargo;

import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo);
    void editar(Cargo cargo);
    void excluir(Long id);
    Cargo buscarPorId(Long id);
    List<Cargo> buscarTodos();
    boolean cargoTemFuncionario(Long id);
}
