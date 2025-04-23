package com.example.senai.web.clientes;

import com.example.senai.core.entity.Cliente;
import com.example.senai.core.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public String clientes(Model model) {
        //vai ate o banco de dados, e procura todos os cliente
        var clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes/index";
    }

    @GetMapping("/novo")
    public String form(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/form";
    }

    @PostMapping("/salvar")
    public String formSalvarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String formEditarClientes(@PathVariable Long id, Model model){
        var cliente = clienteRepository.findById(id).
                orElseThrow(() -> new RuntimeException("cliente não encontrado."));
        model.addAttribute("cliente", cliente);
        return "clientes/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }

}
