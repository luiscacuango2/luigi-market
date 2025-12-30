package com.luiscacuango.market.domain.service;

import com.luiscacuango.market.domain.Purchase;
import com.luiscacuango.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getPurchaseByCustomerId(int customerId) {
        return purchaseRepository.getByClient(String.valueOf(customerId));
    }

    public Purchase save(Purchase purchase) {
        // Si el ID viene como 0, lo forzamos a null para que sea un INSERT
        if (purchase.getPurchaseId() != null && purchase.getPurchaseId() == 0) {
            purchase.setPurchaseId(null);
        }
        return purchaseRepository.save(purchase);
    }
}
