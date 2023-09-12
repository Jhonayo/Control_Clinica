package med.voll.api.controller;

import med.voll.api.domain.paciente.DatosListadoPaciente;
import med.voll.api.domain.paciente.DatosRegistroPaciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public void registrar(@RequestBody DatosRegistroPaciente datosRegistroPaciente ){
        System.out.println(datosRegistroPaciente);
    }

    @GetMapping
    public Page<DatosListadoPaciente> listadoPacientes(@PageableDefault(page=0,size=10,sort = {"nombre"})Pageable paginacion){
        return pacienteRepository.findAll(paginacion).map(DatosListadoPaciente::new);
    }
}
