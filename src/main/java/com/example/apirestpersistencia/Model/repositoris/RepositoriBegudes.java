package com.example.apirestpersistencia.Model.repositoris;

import com.example.apirestpersistencia.Model.entitats.Beguda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriBegudes extends JpaRepository<Beguda,String> {
    List<Beguda> findByTipus(String tipus);
    long countByTipus(String tipus);
    List<Beguda> findByPreuLessThan(double preu);
}
