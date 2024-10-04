package com.awhats.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awhats.demo.models.Cliente;
import com.awhats.demo.repositories.IClienteService;
import com.awhats.demo.repositories.ICliente;

@Service
public class ClienteService implements IClienteService{

    //Programacion de funciones para encontrar y modificar modelos
    @Autowired
    private ICliente data;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>)data.findAll();
    }

    @Override
    public int save(Cliente cliente) {
        int res=0;
        Cliente c = data.save(cliente);
        if(!c.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public int update(Cliente cliente) {
        if (data.existsById(cliente.getId())) {
            data.save(cliente);
            return cliente.getId();
        } else {
            return -1;
        }
    }
}