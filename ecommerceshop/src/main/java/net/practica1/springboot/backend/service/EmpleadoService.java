package net.practica1.springboot.backend.service;

import java.util.List;
import net.practica1.springboot.backend.model.Empleado;

public interface EmpleadoService {

    Empleado saveEmpleado(Empleado empleado);
    List<Empleado> getAllEmpleados();
    Empleado getEmpleadoById(long id);
    Empleado updateEmpleado(Empleado empleado, long id);
    void deleteEmpleado(long id);
    
}
