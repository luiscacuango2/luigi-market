package com.luiscacuango.market.persistence;

import com.luiscacuango.market.persistence.crud.ProductoCrudRepository;
import com.luiscacuango.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getALL() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
