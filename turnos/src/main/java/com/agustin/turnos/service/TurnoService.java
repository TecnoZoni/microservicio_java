package com.agustin.turnos.service;

import com.agustin.turnos.model.Paciente;
import com.agustin.turnos.model.Turno;
import com.agustin.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TurnoService implements ITurnoService {
    
    private final ITurnoRepository turnoRepo;
    private final RestTemplate apiConsumir;
    
    public TurnoService(ITurnoRepository turnoRepo, RestTemplate apiConsumir) {
        this.turnoRepo = turnoRepo;
        this.apiConsumir = apiConsumir;
    }
    
    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }
    
    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }
    
    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        
        Paciente pac = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/" + dniPaciente, Paciente.class);
        String nombreCompleto = pac.getNombre() + " " + pac.getApellido();
        
        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompleto);
        
        turnoRepo.save(turno);
    }
    
    @Override
    public void editTurno(Turno turno) {
        turnoRepo.save(turno);
    }
    
    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }
    
}
