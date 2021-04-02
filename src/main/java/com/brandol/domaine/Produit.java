package com.brandol.domaine;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Produit extends PanacheEntity {

    public String numeroRef;
    public String nom;
    public int prix;
    public float quantite;
    public String image;

    public Produit() {

    }
    public String getNumeroRef(){
        return numeroRef;
    }
    public void setNumeroRef(String numeroRef) {
        this.numeroRef= numeroRef;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public int getPrix(){
        return prix;
    }
    public void setPrix(int prix){
        this.prix= prix;
    }
    public float getQuantite(){
        return quantite;
    }
    public void setQuantite(float qte){
        this.quantite = qte;
    }
    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image= image;
    }
}
