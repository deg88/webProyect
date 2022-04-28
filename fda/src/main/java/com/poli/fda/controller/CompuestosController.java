package com.poli.fda.controller;

import com.poli.fda.entity.Compuesto;
import com.poli.fda.repository.CompuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/parcial")
public class CompuestosController {

    @Autowired
    CompuestoRepository compuestoRepository;

    //Load List of Books
    @PostMapping("/compuestos")
    public String createEmployeeList(@RequestBody List<Compuesto> compuestos) {
        compuestoRepository.saveAll(compuestos);
        return "done";
    }

    @GetMapping("/compuestos")
    public List<Compuesto> getAllBooks() {
        // The BookRepository is already injected and you can use it
        return compuestoRepository.findAll();
    }

    @GetMapping("/compuestos/{name}")
    public Compuesto getCompuestoByName(@PathVariable String name) {
        Compuesto compuesto =  compuestoRepository.findById(name).get();
        return compuesto;
    }

    @GetMapping("/servicio1/{min}/{max}")
    public List<Compuesto> getCompuestoByRDARange(@PathVariable int min, @PathVariable int max) {
        List<Compuesto> compuestos;
        if(min>max){
             compuestos = compuestoRepository.findCompuestosByRdaIsBetween(max,min).get();
        }else{
             compuestos =  compuestoRepository.findCompuestosByRdaIsBetween(min,max).get();
        }
        return compuestos;
    }



}
