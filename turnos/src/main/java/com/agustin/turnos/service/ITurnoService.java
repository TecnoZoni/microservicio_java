package com.agustin.turnos.service;

import com.agustin.turnos.model.Turno;
import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {

    public List<Turno> getTurnos();

    public Turno findTurno(Long id);

    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);

    public void editTurno(Turno turno);

    public void deleteTurno(Long id);
}
