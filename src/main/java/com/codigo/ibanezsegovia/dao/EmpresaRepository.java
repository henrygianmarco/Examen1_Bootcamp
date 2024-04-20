package com.codigo.ibanezsegovia.dao;

import com.codigo.ibanezsegovia.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity,Long> {
}
