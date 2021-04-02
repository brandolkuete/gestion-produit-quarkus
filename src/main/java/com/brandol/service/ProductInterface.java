package com.brandol.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import com.brandol.domaine.Produit;

public interface ProductInterface {
    public void saveProduit(Produit produit);
    public List<Produit> allProducts();
    public Optional<Produit> findById(Long productId);
    public void deleteProduct(Long productId);
    public Produit updateProduct(Long id, Produit produit);
    
}
