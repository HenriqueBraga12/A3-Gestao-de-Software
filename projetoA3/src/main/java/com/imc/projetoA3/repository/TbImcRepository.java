package com.imc.projetoA3.repository;

import com.imc.projetoA3.entity.TbImc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbImcRepository extends JpaRepository<TbImc, Long> {

}
