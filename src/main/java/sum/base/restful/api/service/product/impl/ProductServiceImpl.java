package sum.base.restful.api.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum.base.restful.api.dto.request.product.CreateProductRequest;
import sum.base.restful.api.dto.request.product.UpdateProductRequest;
import sum.base.restful.api.dto.response.product.ProductResponse;
import sum.base.restful.api.entity.product.Product;
import sum.base.restful.api.error.NotFoundException;
import sum.base.restful.api.repository.product.ProductRepository;
import sum.base.restful.api.service.product.ProductService;
import sum.base.restful.api.util.ValidationUtil;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    ProductServiceImpl(
            ProductRepository productRepository,
            ValidationUtil validationUtil
    ) {
        this.productRepository = productRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public ProductResponse create(CreateProductRequest createProductRequest) {
        validationUtil.validate(createProductRequest);
        return ProductResponse.fromEntity(
                productRepository.save(
                        createProductRequest.toEntity("USER")
                )
        );
    }

    @Override
    public ProductResponse update(UpdateProductRequest updateProductRequest) {
        validationUtil.validate(updateProductRequest);
        Product product = productRepository.findById(updateProductRequest.getProductId()).orElse(new Product());
        product = updateProductRequest.toEntity(product, "UPDATE");

        if (product.getProductId() == null){
            throw new NotFoundException("Product not found");
        }

        return ProductResponse.fromEntity(
                productRepository.save(product)
        );
    }
}
