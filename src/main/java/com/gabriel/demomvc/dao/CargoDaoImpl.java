package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Cargo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public  class CargoDaoImpl extends AbstractDao<Cargo, Long> implements  CargoDao{


    @Override
    public List<Cargo> fndAll() {
        return null;
    }
}
