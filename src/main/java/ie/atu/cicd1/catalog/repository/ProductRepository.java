package ie.atu.cicd1.catalog.repository;

import ie.atu.cicd1.catalog.model.Product;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
