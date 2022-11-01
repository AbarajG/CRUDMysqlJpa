
package net.practica1.springboot.backend.service;

import java.util.List;
//import java.util.Optional;
import net.practica1.springboot.backend.exception.ResourceNotFoundException;
import net.practica1.springboot.backend.model.Empleado;
import net.practica1.springboot.backend.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    private EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        super(); 
        this.empleadoRepository = empleadoRepository;
    }
    
    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(long id) {
//        Optional <Empleado> empleado = empleadoRepository.findById(id);
//        if (empleado.isPresent()) {
//            return empleado.get();
//        }else{
//            throw new  ResourceNotFoundException("empleado", "id", id);
//        }
        return empleadoRepository.findById(id).orElseThrow(() -> 
                new ResourceNotFoundException("Empleado", "id", id));
    }
    
    @Override
    public Empleado updateEmpleado(Empleado empleado, long id) {
        
        //Necesitamos checar  empleado si existe en la db
        Empleado existingEmpleado = empleadoRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Empleado", "id", id));
        
        existingEmpleado.setNombre(empleado.getNombre());
        existingEmpleado.setApellido(empleado.getApellido());
        existingEmpleado.setEdad(empleado.getEdad());
        existingEmpleado.setEmail(empleado.getEmail());
        
        //Guardaremos el empleado existente
        empleadoRepository.save(existingEmpleado);
        return existingEmpleado;
    }

    @Override
    public void deleteEmpleado(long id) {
        
        //Checar si el empleado existe en la base de datos
        empleadoRepository.findById(id).orElseThrow(() -> 
                new ResourceNotFoundException("Empleado", "id", id));
        empleadoRepository.deleteById(id);
    }

}
