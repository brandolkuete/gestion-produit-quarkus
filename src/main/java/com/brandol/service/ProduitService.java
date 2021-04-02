package com.brandol.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.brandol.domaine.Produit;
import com.brandol.repository.ProduitRepository;

@ApplicationScoped
public class ProduitService implements ProductInterface {

    @Inject
    ProduitRepository produitRepository;

    @Inject
    EntityManager entityManager;

    @Override
    public void saveProduit(Produit produit) {
        produitRepository.persist(produit);
    }

    @Override
    public List<Produit> allProducts() {
        return produitRepository.listAll();
    }

    @Override
    public Optional<Produit> findById(Long productId) {
        return produitRepository.findByIdOptional(productId);
    }

    @Override
    public void deleteProduct(Long productId) {
        produitRepository.deleteById(productId);
        
    }

    @Override
    public Produit updateProduct(Long id, Produit produit) {
        Produit prod = produitRepository.findById(id);
        prod.setNumeroRef(produit.getNumeroRef());
        prod.setNom(produit.getNom());
        prod.setPrix(produit.getPrix());
        prod.setQuantite(produit.getQuantite());
        prod.setImage(produit.getImage());
        return entityManager.merge(prod);
    }
    
}
