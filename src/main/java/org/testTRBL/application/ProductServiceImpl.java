package org.testTRBL.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.testTRBL.adapters.out.ProductRepository;
import org.testTRBL.domain.Product;

import java.util.List;
@ApplicationScoped
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.listAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return repository.findById(Long.valueOf(id));
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        repository.persist(product);
        return product;
    }

    @Override
    @Transactional
    public Product updateProduct(Integer id, Product product) {
        Product productUpdate= repository.findById(Long.valueOf(id));
        if (productUpdate != null) {
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setStock(product.getStock());
        }
        return productUpdate;
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        repository.deleteById(Long.valueOf(id));
    }
}
