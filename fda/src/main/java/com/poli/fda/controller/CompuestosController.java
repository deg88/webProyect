package com.poli.fda.controller;

import com.poli.fda.entity.Compuesto;
import com.poli.fda.repository.CompuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/parcial")
public class CompuestosController {

    @Autowired
    CompuestoRepository compuestoRepository;

    @PostMapping("/compuestos")
    public String createEmployeeList(@RequestBody List<Compuesto> compuestos) {
        compuestoRepository.saveAll(compuestos);
        return "done";
    }

    @GetMapping("/compuestos")
    public List<Compuesto> getAllBooks() {
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

    @GetMapping("/servicio2/{phrase}/{tui}")
    public List<Compuesto> getComponentFilterAndGreaterThanTuiValor(@PathVariable String phrase, @PathVariable int tui) {
        List<Compuesto> compuestos =  compuestoRepository.findCompuestosByNameContains(phrase).get();
        return compuestos.stream().filter(compuesto -> compuesto.getTui() > tui).collect(Collectors.toList());
    }

    @GetMapping("/servicio3/{start}/{end}")
    public List<Compuesto> getCompuestoThatStartWithAndEndWith(@PathVariable String start, @PathVariable String end) {
        List<Compuesto> compuestos = compuestoRepository.findCompuestosByNameStartsWith(start).get();

        return compuestos;
    }


}
