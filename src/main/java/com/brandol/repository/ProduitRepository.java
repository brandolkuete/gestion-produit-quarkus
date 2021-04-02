package com.brandol.repository;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import com.brandol.domaine.Produit;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProduitRepository implements PanacheRepository<Produit>{

    public Optional<Produit> findByIdOptional(Long id) {
        return find("id",id).firstResultOptional();
    }
    public Produit findById(Long id) {
        return find("id",id).firstResult();
    }
}
