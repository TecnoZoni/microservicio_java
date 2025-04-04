package com.agustin.pacientes.service;

import com.agustin.pacientes.model.Paciente;
import com.agustin.pacientes.repository.IPacienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService {
    
    private final IPacienteRepository pacienteRepo;
    
    public PacienteService(IPacienteRepository pacienteRepo) {
        this.pacienteRepo = pacienteRepo;
    }
    
    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }
    
    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }
    
    @Override
    public void savePaciente(Paciente paciente) {
        pacienteRepo.save(paciente);
    }
    
    @Override
    public void editPaciente(Paciente paciente) {
        pacienteRepo.save(paciente);
    }
    
    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }
    
}
