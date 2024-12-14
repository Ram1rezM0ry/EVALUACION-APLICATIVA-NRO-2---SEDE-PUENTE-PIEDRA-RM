package com.example.Evaluacion.Aplicativa2RM.controller;

import com.example.Evaluacion.Aplicativa2RM.model.Trabajador;
import com.example.Evaluacion.Aplicativa2RM.service.TrabajadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    private final TrabajadorService service;

    public TrabajadorController(TrabajadorService service) {
        this.service = service;
    }

    @GetMapping
    public String listarTrabajadores(Model model) {
        model.addAttribute("trabajadores", service.listarTrabajadores());
        return "trabajadores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioTrabajador(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        return "formularioTrabajador";
    }

    @PostMapping
    public String guardarTrabajador(@ModelAttribute Trabajador trabajador) {
        if (trabajador.getId() != null) {
            // Si ya tiene un id, es una edición
            service.guardarTrabajador(trabajador);
        } else {
            // Si no tiene id, es una creación
            trabajador.setId(null);  // Asegúrate de que el id sea null para evitar duplicados
            service.guardarTrabajador(trabajador);
        }
            return "redirect:/trabajadores";
    }


    @GetMapping("/editar/{id}")
    public String editarTrabajador(@PathVariable Long id, Model model) {
        model.addAttribute("trabajador", service.buscarTrabajadorPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id)));
        return "formularioTrabajador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTrabajador(@PathVariable Long id) {
        service.eliminarTrabajador(id);
        return "redirect:/trabajadores";
    }
}