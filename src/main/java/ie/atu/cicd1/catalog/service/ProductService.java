package ie.atu.cicd1.catalog.service;

import ie.atu.cicd1.catalog.model.Category;
import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.repository.CategoryRepository;
import ie.atu.cicd1.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
   private final ProductRepository productRepository;
   private final CategoryRepository categoryRepository;

   public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
       this.productRepository = productRepository;
       this.categoryRepository = categoryRepository;
   }
public List<Product> getAllProducts() {
       return productRepository.findAll();
}
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product not found"
                ));
    }
public List<Product> getByMinPrice(BigDecimal minPrice) {
    return productRepository.findByMinPrice(minPrice);
}
    }



