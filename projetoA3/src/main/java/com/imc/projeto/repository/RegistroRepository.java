package com.imc.projeto.repository;

import com.imc.projeto.entity.RegistroImc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroImc, Long> {

}
