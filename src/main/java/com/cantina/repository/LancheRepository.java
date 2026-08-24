package com.cantina.repository;

import com.cantina.dto.LancheListaDTO;
import com.cantina.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Long> {
}
