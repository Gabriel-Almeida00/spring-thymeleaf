package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Cargo;
import com.gabriel.demomvc.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public  class CargoDaoImpl extends AbstractDao<Cargo, Long> implements  CargoDao{

    public PaginacaoUtil<Cargo> buscaPaginada( int pagina){
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;
        List<Cargo> cargos = getEntityManager()
                .createQuery("select c from Cargo c order by c.nome asc", Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();
        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, cargos);
    }

}
