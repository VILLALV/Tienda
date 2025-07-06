package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto categoria) {
        return productoDao.findById(categoria.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto categoria) {
        productoDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Producto categoria) {
        productoDao.deleteById(categoria.getIdProducto());
    }
}