package sum.base.restful.api.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import sum.base.restful.api.entity.product.Sales;
import sum.base.restful.api.entity.product.SalesDetail;

public interface SalesDetailRepository extends JpaRepository<SalesDetail, String> {

}
