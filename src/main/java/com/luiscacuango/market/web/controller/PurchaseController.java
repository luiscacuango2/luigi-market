package com.luiscacuango.market.web.controller;

import com.luiscacuango.market.domain.Purchase;
import com.luiscacuango.market.domain.service.PurchaseService;
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
@RequestMapping("/purchases")
@Tag(name = "Compras", description = "Catálogo y gestión de compras del supermercado")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    // Otros métodos...
    @GetMapping("/all")
    @Operation(summary = "Lista todas las compras", description = "Obtiene un listado completo de compras")
    @ApiResponse(responseCode = "200", description = "Compras encontradas con éxito", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)))
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Lista todas las compras de un cliente", description = "Obtiene un listado completo de compras de un cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Compras encontradas con éxito por cliente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Purchase.class))),
            @ApiResponse(responseCode = "404", description = "El ID proporcionado no corresponde a ningún cliente",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"message\": \"Compra no encontrada con el ID del cliente 4546221\"}")))
    })
    public ResponseEntity<List<Purchase>> getByPurchasesByCustomerId(@Parameter(description = "ID del cliente", required = true, example = "4546221") @PathVariable("customerId") int customerId) {
        return purchaseService.getPurchaseByCustomerId(customerId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Crea una nueva compra", description = "Crea una nueva compra")
    @ApiResponse(responseCode = "201", description = "Compra creada con éxito")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

}
