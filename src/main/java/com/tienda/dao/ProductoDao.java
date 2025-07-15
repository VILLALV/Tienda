package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends JpaRepository<Producto, Long> {

    //Ejemplo de método utilizando Métodos de Query
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Practica04

    // Método derivado usando IN con lista de existencias
    public List<Producto> findByExistenciasIn(List<Integer> existencias);

// Método derivado usando NOT IN con lista de existencias
    public List<Producto> findByExistenciasNotIn(List<Integer> existencias);

// Consulta JPQL para existencias en rango (entre mínimo y máximo)
    @Query("SELECT p FROM Producto p WHERE p.existencias BETWEEN :existenciasInf AND :existenciasSup ORDER BY p.descripcion ASC")
    public List<Producto> findByExistenciasBetween(@Param("existenciasInf") Integer existenciasInf,
            @Param("existenciasSup") Integer existenciasSup);

}
