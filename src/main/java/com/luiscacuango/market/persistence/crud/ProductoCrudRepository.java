package com.luiscacuango.market.persistence.crud;

import com.luiscacuango.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
