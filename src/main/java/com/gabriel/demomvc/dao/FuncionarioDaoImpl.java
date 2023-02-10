package com.gabriel.demomvc.dao;

import com.gabriel.demomvc.domain.Funcionario;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

    public List<Funcionario> findByNome(String nome){

        return createQuery("select f from Funcionario f where f.nome  like concat('%',?1,'%')", nome);
    }
    @Override
    public List<Funcionario> findByCargoId(Long id) {
        return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
    }
}
