package sum.base.restful.api.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import sum.base.restful.api.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
