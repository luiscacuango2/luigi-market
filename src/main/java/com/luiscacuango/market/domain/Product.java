package com.luiscacuango.market.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({ "productId", "name", "categoryId", "price", "stock", "active", "category" })
public class Product {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Identificador único del producto", example = "1")
    private Integer productId;
    @Schema(description = "Nombre del producto", example = "Leche")
    private String name;
    @Schema(description = "Identificador de la categoría del producto", example = "1")
    private int categoryId;
    @Schema(description = "Precio del producto", example = "2.99")
    private double price;
    @Schema(description = "Stock del producto", example = "50")
    private int stock;
    @Schema(description = "Estado del producto", example = "true")
    private boolean active;
    @Schema(description = "Categoría del producto", example = "Lacteos")
    private Category category;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
