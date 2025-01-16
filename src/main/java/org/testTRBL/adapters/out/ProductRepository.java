package org.testTRBL.adapters.out;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.testTRBL.domain.Product;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}
