package sum.base.restful.api.service.product;

import sum.base.restful.api.dto.request.sales.CreateSalesRequest;

public interface SalesService {

    String create(CreateSalesRequest createSalesRequest);

}
