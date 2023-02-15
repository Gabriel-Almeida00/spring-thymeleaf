package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Cargo;
import com.gabriel.demomvc.util.PaginacaoUtil;

import java.util.List;

public interface CargoDao {

    void save (Cargo cargo);
    void update (Cargo cargo);
    void delete (Long id);
    Cargo findById (Long id);
    List<Cargo> findAll();
    PaginacaoUtil<Cargo> buscaPaginada( int pagina, String direcao);
}
