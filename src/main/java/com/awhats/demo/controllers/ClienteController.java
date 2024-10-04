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

import com.awhats.demo.repositories.ICliente;
import com.awhats.demo.repositories.IClienteService;
import com.awhats.demo.models.Cliente;

@Controller
@RequestMapping
public class ClienteController {
    
    @Autowired
    private ICliente service;
    @Autowired
    private IClienteService srvc;

    @GetMapping("/")
    public String login(){
        return "Index";
    }

    //Aqui se maneja el manejo de direcciones y las condicionales del modelo.
    @PostMapping("/login")
    public String ingresar(@RequestParam String Number, @RequestParam String Password, Model model){
        Cliente cliente = service.findByTelefono(Number);
        if(cliente != null && cliente.getContrasena().equals(Password)){
            return "redirect:/dashboard/"+cliente.getId();
        }
        else{
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "Index";
        }
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("cliente", new Cliente());
        return "Registro";
    }

    @PostMapping("/save")
    public String save(@Validated Cliente cliente, Model model){
        service.save(cliente);
        return "redirect:/dashboard/"+cliente.getId();
    }

    @PostMapping("/update")
    public String update(@Validated Cliente cliente, Model model){
        srvc.update(cliente);
        return "redirect:/dashboard/"+cliente.getId();
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Cliente>clientes=service.findAll();
        model.addAttribute("cliente", clientes);
        return "Registro";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable int id, Model model){
        Cliente cliente=service.findById(id);
        model.addAttribute("cliente", cliente);
        return "Registro";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        service.deleteById(id);
        return "redirect:/listar";
    }
}