package com.imc.projeto.repository;

import com.imc.projeto.entity.RegistroImcUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroImcUsuario, Long> {

}
