package com.awhats.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awhats.demo.models.Consumo;
import java.util.List;

@Repository
public interface IConsumo extends JpaRepository<Consumo, Integer>{
    List<Consumo> findById(int id);
    List<Consumo> findByIdCliente(int idCliente);
}