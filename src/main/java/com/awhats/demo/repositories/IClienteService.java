package com.awhats.demo.repositories;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awhats.demo.models.Cliente;

//Funciones para modificar los modelos
@Service
public interface IClienteService{
    public List<Cliente> findAll();
    public int save(Cliente cliente);
    public int update(Cliente cliente);
}