package com.pedromiranda.transportadoraapi.repository;

import com.pedromiranda.transportadoraapi.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
}
