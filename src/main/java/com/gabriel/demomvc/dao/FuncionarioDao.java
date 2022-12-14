package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    void save (Funcionario funcionario);
    void update (Funcionario funcionario);
    void delete(Long id);
    Funcionario findById(Long id);
    List<Funcionario> findAll();
}
