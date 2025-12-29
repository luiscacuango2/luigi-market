package com.luiscacuango.market.persistence;

import com.luiscacuango.market.persistence.crud.ProductoCrudRepository;
import com.luiscacuango.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getALL() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByIdCantidadStockLessThanAndEstado(cantidad, true);

    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }
}
