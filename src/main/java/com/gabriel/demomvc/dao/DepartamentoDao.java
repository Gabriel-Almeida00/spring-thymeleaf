package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Departamento;

import java.util.List;

public interface DepartamentoDao {

    void save (Departamento departamento);
    void update (Departamento departamento);
    void delete (Long id);
    Departamento findById (Long id);
    List<Departamento> fndAll();
}
