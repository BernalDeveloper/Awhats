package com.awhats.demo.repositories;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awhats.demo.models.Consumo;

@Service
public interface IConsumoService {
    public List<Consumo> findAll();
    public int save(Consumo consumo);
}