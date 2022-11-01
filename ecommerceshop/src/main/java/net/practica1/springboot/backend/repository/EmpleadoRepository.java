package net.practica1.springboot.backend.repository;

import net.practica1.springboot.backend.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
