package sum.base.restful.api.service.product;

import sum.base.restful.api.dto.request.product.CreateProductRequest;
import sum.base.restful.api.dto.request.product.UpdateProductRequest;
import sum.base.restful.api.dto.response.product.ProductResponse;

public interface ProductService {

    ProductResponse create(CreateProductRequest createProductRequest);

    ProductResponse update(UpdateProductRequest updateProductRequest);

}
