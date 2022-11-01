package net.practica1.springboot.backend.controller;

import java.util.List;
import net.practica1.springboot.backend.model.Empleado;
import net.practica1.springboot.backend.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/empleado")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        super();
        this.empleadoService = empleadoService;
    }
    
    //Crear el API Rest
    //Guardar empleado
    @PostMapping 
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado){
        return new ResponseEntity(empleadoService.saveEmpleado(empleado), HttpStatus.CREATED);
    }
    
    //Traer todos los empleados
    @GetMapping
    public List<Empleado> getAllempleados(){
        return empleadoService.getAllEmpleados();
    }
    
    //Traer un empleado por id
    @GetMapping("{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("id")long empleadoId){
        return new ResponseEntity<>(empleadoService.getEmpleadoById(empleadoId), HttpStatus.OK);
//        return new ResponseEntity<Empleado>(empleadoService.getEmpleadoById(empleadoId), HttpStatus.OK);
    }
    
    //Actualizar empleado
    @PutMapping("{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable("id") long id,
                                                    @RequestBody Empleado empleado){
        return new ResponseEntity<Empleado>(empleadoService.updateEmpleado(empleado, id), HttpStatus.OK);
    }
    
    //Eliminar empleado
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable("id") long id){
        //Elimina el empleado de la db
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<String>("Empleado eliminado",HttpStatus.OK);
    }
    
}
