package ie.atu.cicd1.catalog.repository;

import ie.atu.cicd1.catalog.model.Product;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {
@Query("SELECT p FROM Product p WHERE p.price >= :minPrice ORDER BY p.price ASC")
    List<Product> findByMinPrice(@Param("minPrice") BigDecimal minPrice);
}
