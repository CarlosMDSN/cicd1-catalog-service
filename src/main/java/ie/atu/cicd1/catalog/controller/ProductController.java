package ie.atu.cicd1.catalog.controller;

import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }


@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/min_price")
    public List<Product> getByMinPrice(@RequestParam BigDecimal minPrice) {
        return productService.getByMinPrice(minPrice);
    }
}
