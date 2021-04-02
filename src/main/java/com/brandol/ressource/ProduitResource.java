package com.brandol.ressource;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.brandol.domaine.Produit;
import com.brandol.service.ProduitService;

@Path("/produits")
@ApplicationScoped
public class ProduitResource {

    @Inject
    ProduitService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response all() {
        List<Produit> produits= service.allProducts();
        return Response.ok(produits).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/save")
    @Transactional
    public Response save(Produit produit) {
        service.saveProduit(produit);
        return Response.status(Status.CREATED).entity(produit).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        Optional<Produit> produit = service.findById(id);

        if(produit.isPresent()) {
            return Response.ok(produit).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteProduct(@PathParam("id") Long id){
        service.deleteProduct(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateProduct(@PathParam("id") Long id, Produit produit) {
        Produit prod= service.updateProduct(id, produit);
        return Response.ok(prod).build();
    }


}