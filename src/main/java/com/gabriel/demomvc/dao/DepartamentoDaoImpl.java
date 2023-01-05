package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Departamento;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public  class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao{


    @Override
    public List<Departamento> fndAll() {
        return null;
    }
}
