package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {

    // Se obtiene un listado de categorias en un List
    public List<Producto> getProductos(boolean activos);

    // Se obtiene un Categoria, a partir del id de un categoria
    public Producto getProducto(Producto producto);

    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Producto producto);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Producto producto);

    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);
    
    //practica04

    // Filtrar productos por existencias entre un rango (consulta ampliada)
    public List<Producto> findByExistenciasBetween(Integer existenciasInf, Integer existenciasSup);

// Filtrar productos cuyos existencias estén en una lista específica (IN)
    public List<Producto> findByExistenciasIn(List<Integer> existencias);

// Filtrar productos cuyos existencias NO estén en una lista específica (NOT IN)
    public List<Producto> findByExistenciasNotIn(List<Integer> existencias);
}
