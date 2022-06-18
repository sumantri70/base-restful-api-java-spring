package sum.base.restful.api.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import sum.base.restful.api.entity.product.Sales;

public interface SalesRepository extends JpaRepository<Sales, String> {

}
