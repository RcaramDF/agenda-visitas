package com.agenda.service;

import com.agenda.model.Visita;
import com.agenda.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {
    @Autowired
    private VisitaRepository repository;

    public Visita salvar(Visita visita) {
        return repository.save(visita);
    }

    public List<Visita> listarTodas() {
        return repository.findAll();
    }
}
