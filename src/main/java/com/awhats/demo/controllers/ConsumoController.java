package com.awhats.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.awhats.demo.repositories.IConsumo;
import com.awhats.demo.repositories.ICliente;
import com.awhats.demo.models.Consumo;
import com.awhats.demo.models.Cliente;

@Controller
@RequestMapping
public class ConsumoController {

    @Autowired
    private IConsumo service;
    @Autowired
    private ICliente srvc;

    @GetMapping("/dashboard/{id}")
    public String dashboard(@PathVariable int id, Model model){
        List<Consumo>consumos=service.findByIdCliente(id);
        Cliente cliente = srvc.findById(id);
        model.addAttribute("consumos", consumos);
        model.addAttribute("cliente", cliente);
        return "Dashboard";
    }
}