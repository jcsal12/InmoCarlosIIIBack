package com.example.InmoCarlosIII.Repositories;

import com.example.InmoCarlosIII.Entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}
