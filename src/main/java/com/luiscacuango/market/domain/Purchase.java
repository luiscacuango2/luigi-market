package com.luiscacuango.market.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Identificador único de la compra", example = "1")
    private Integer purchaseId;
    @Schema(description = "Identificador del cliente", example = "1")
    private String clientId;
    @Schema(description = "Fecha de compra", example = "2025-12-30T08:06:02.001Z")
    private LocalDateTime date;
    @Schema(description = "Método de pago", example = "Tarjeta de crédito")
    private String paymentMethod;
    @Schema(description = "Comentarios adicionales", example = "")
    private String comment;
    @Schema(description = "Estado de la compra", example = "Pendiente")
    private String state;
    @Schema(description = "Items de la compra", example = "")
    private List<PurchaseItem> items;

    // Getters y setters

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }
}
