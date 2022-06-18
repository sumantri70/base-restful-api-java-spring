package sum.base.restful.api.controller;

import org.bouncycastle.asn1.cms.MetaData;
import org.hibernate.cfg.MetadataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sum.base.restful.api.dto.base.RestResponse;
import sum.base.restful.api.dto.request.product.CreateProductRequest;
import sum.base.restful.api.dto.request.product.UpdateProductRequest;
import sum.base.restful.api.dto.response.product.ProductResponse;
import sum.base.restful.api.service.product.ProductService;
import org.springframework.http.MediaType;

import javax.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    RestResponse<ProductResponse> createProduct(
            @RequestBody
            CreateProductRequest createProductRequest
    ){
        return new RestResponse<ProductResponse>().success(
                productService.create(createProductRequest)
        );
    }

    @PutMapping(value = "/{productId}")
    RestResponse<ProductResponse> updateProduct(
            @PathVariable("productId")
            String productId,

            @RequestBody
            UpdateProductRequest updateProductRequest
    ){
        updateProductRequest.setProductId(productId);
        return new RestResponse<ProductResponse>().success(
                productService.update(updateProductRequest)
        );
    }

}
