package com.example.demo.controller;

import com.example.demo.entity.Pedido;
import com.example.demo.entity.Items;
import com.example.demo.repository.Repository;
import com.example.demo.dto.clienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Pedido/v1/")
public class Controller {

    @Autowired
    Repository repository;

    @PostMapping
    public Pedido creat(@RequestBody @Valid Pedido pedido){
//        for (Items p : pedido.getItems()){
//            p.setPrecoTotal(p.getPrecoIndividual()* p.getQuantidade());
//        }
        Pedido pedidoSaved = repository.save(pedido);
        return pedidoSaved;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Pedido> getClineteById(@PathVariable Long id){
        Optional<Pedido> clienteReturned = repository.findById(id);
        return clienteReturned;
    }
    @DeleteMapping("/{id}")
    public String deleteClienteById(@PathVariable Long id){
        try{
            Optional<Pedido> cliente = Optional.of(repository.getById(id));
            if(cliente.isPresent()){
                repository.deleteById(id);
                return "Cliente de " + id + " deletado com sucesso";
            }else{
                throw new Exception("Cliente inexistente");
            }
        }catch(Exception e){
            e.printStackTrace();
            return "O cliente de " + id + " não existe para ser deletado!" +
                    " Por favor, entre em contato com o atendimento ...";
        }
    }

    @GetMapping
    public List<Pedido> listCliente(){
        return repository.findAll();
    }

    @PutMapping("/atualize/{id}")
    public String updateClineteById(@RequestBody clienteDTO clienteDTO, @PathVariable Long id){
        Optional<Pedido> velhoCliente = repository.findById(id);
        if(velhoCliente.isPresent()){
            Pedido pedido = velhoCliente.get();
            pedido.setEndereco(clienteDTO.getEndereco());
            repository.save(pedido);
            return "Cliente de ID" + pedido.getId() + " atualizado com sucesso!";
        }else{
            return "Cliente de ID " + id + " não existe!";
        }
    }
}
