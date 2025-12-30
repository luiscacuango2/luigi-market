package com.luiscacuango.market.web.controller;

import com.luiscacuango.market.domain.Product;
import com.luiscacuango.market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Productos", description = "Catálogo y gestión de productos del supermercado")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @Operation(summary = "Lista todos los productos", description = "Obtiene un listado completo de productos con su stock y categoría")
    @ApiResponse(responseCode = "200", description = "Productos encontrados con éxito")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID",
            description = "Retorna un producto específico basado en su identificador único.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto encontrado con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "404", description = "El ID proporcionado no corresponde a ningún producto",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"message\": \"Producto no encontrado con el ID: 7\"}")))
    })
    public ResponseEntity<Product> getProduct(@Parameter(description = "ID numérico del producto", required = true, example = "7") @PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Lista todos los productos por un ID de categoría", description = "Obtiene un listado completo de productos por un ID de categoría")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Productos encontrado con éxito por categoría",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "404", description = "El ID proporcionado no corresponde a ninguna categoría",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"message\": \"Categoría no encontrada con el ID: 0\"}")))
    })
    public ResponseEntity<List<Product>> getByCategory(@Parameter(description = "ID de la categoría", required = true, example = "1") @PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Crea un nuevo producto", description = "Crea un nuevo producto")
    @ApiResponse(responseCode = "201", description = "Producto creado con éxito")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un producto por su ID", description = "Elimina un producto específico por su ID")
    @ApiResponse(responseCode = "200", description = "Producto eliminado con éxito")
    public ResponseEntity delete(@Parameter(description = "ID del producto", required = true, example = "7") @PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
