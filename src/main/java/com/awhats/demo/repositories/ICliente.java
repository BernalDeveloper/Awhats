package com.awhats.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awhats.demo.models.Cliente;

//Manejo de funciones para modelos por un parametro
@Repository
public interface ICliente extends JpaRepository<Cliente, Integer>{
    Cliente findByTelefono(String telefono);
    Cliente findById(int id);
}