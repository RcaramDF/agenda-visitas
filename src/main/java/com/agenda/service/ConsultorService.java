package com.agenda.service;

import com.agenda.model.Consultor;
import com.agenda.repository.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultorService {
    @Autowired
    private ConsultorRepository repository;

    public Consultor salvar(Consultor consultor) {
        return repository.save(consultor);
    }

    public List<Consultor> listarTodos() {
        return repository.findAll();
    }
}
