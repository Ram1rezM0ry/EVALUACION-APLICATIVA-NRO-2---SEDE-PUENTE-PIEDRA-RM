package com.example.Evaluacion.Aplicativa2RM.service;

import com.example.Evaluacion.Aplicativa2RM.model.Trabajador;
import com.example.Evaluacion.Aplicativa2RM.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository repository;

    public List<Trabajador> listarTrabajadores() {
        return repository.findAll();
    }

    public void guardarTrabajador(Trabajador trabajador) {
        repository.save(trabajador);
    }

    public Optional<Trabajador> buscarTrabajadorPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminarTrabajador(Long id) {
        repository.deleteById(id);
    }
}
