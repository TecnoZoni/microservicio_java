package com.agustin.pacientes.service;

import com.agustin.pacientes.model.Paciente;
import java.util.List;

public interface IPacienteService {

    public List<Paciente> getPacientes();

    public Paciente findPaciente(Long id);

    public void savePaciente(Paciente paciente);

    public void editPaciente(Paciente paciente);

    public void deletePaciente(Long id);

    public Paciente findPacienteDni(String dni);
}
