package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CargoDaoImpl extends AbstractDao<Cargo, Long> implements  CargoDao{
}
