package com.imc.projeto.repository;

import com.imc.projeto.entity.TabelaImc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbImcRepository extends JpaRepository<TabelaImc, Long> {

}
