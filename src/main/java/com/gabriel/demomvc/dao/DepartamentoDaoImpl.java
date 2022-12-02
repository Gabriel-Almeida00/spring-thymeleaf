package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Departamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao{

}
