package com.core.imccalculator.repository;

import com.core.imccalculator.entity.TbImc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImcRepository extends JpaRepository<TbImc, Long> {
}
