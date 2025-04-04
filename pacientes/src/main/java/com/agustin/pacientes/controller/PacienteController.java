package com.agustin.pacientes.controller;

import com.agustin.pacientes.model.Paciente;
import com.agustin.pacientes.service.IPacienteService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/traer")
    public List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }

    @GetMapping("/traer/{id}")
    public Paciente getPaciente(@PathVariable Long id) {
        return pacienteService.findPaciente(id);
    }

    @PostMapping("/crear")
    public String savePaciente(@RequestBody Paciente paciente) {
        pacienteService.savePaciente(paciente);
        return "El paciente se creo correctamente";
    }

    @PutMapping("/editar")
    public String editPaciente(@RequestBody Paciente paciente) {
        pacienteService.editPaciente(paciente);
        return "El paciente se edito correctamente";
    }

    @DeleteMapping("/borrar/{id}")
    public String deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return "El paciente se borro correctamente";
    }

}
