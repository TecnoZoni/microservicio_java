package com.agustin.turnos.controller;

import com.agustin.turnos.dto.TurnoDTO;
import com.agustin.turnos.model.Turno;
import com.agustin.turnos.service.ITurnoService;
import java.time.LocalDate;
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
@RequestMapping("/turnos")
public class TurnoController {

    private final ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/traer")
    public List<Turno> trarTurnos() {
        return turnoService.getTurnos();
    }

    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id) {
        return turnoService.findTurno(id);
    }

    @PostMapping("/crear")
    public String saveTurno(@RequestBody TurnoDTO turnoDTO) {

        turnoService.saveTurno(turnoDTO.getFecha(), turnoDTO.getTratamiento(), turnoDTO.getDniPaciente());

        return "El turno se creo correctamente";
    }

    @PutMapping("/editar")
    public String editTurno(@RequestBody Turno turno) {
        turnoService.editTurno(turno);
        return "El turno se edito correctamente";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarTurno(@PathVariable Long id) {
        turnoService.deleteTurno(id);
        return "El turno se elimino correctamente";
    }

}
