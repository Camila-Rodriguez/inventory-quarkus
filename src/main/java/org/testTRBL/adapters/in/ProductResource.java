package org.testTRBL.adapters.in;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.testTRBL.application.ProductService;
import org.testTRBL.domain.Product;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GET
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GET
    @Path("/{id}")
    public Product getProductById(@PathParam("id") Integer id) {
        return productService.getProductById(id);
    }

    @POST
    public Product createProduct(Product product){
        return productService.createProduct(product);
    }

    @PUT
    @Path("/{id}")
    public Product updateProduct(@PathParam("id") Integer id, Product product){
        return productService.updateProduct(id, product);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") Integer id){
         productService.deleteProduct(id);
    }

    }
