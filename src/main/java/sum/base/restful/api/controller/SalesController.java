package sum.base.restful.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sum.base.restful.api.dto.base.RestResponse;
import sum.base.restful.api.dto.request.product.CreateProductRequest;
import sum.base.restful.api.dto.request.product.UpdateProductRequest;
import sum.base.restful.api.dto.request.sales.CreateSalesRequest;
import sum.base.restful.api.dto.response.product.ProductResponse;
import sum.base.restful.api.service.product.ProductService;
import sum.base.restful.api.service.product.SalesService;

@RestController
@RequestMapping("sales")
public class SalesController {

    private SalesService salesService;

    @Autowired
    public SalesController(
            SalesService salesService
    ) {
        this.salesService = salesService;
    }

    @PostMapping()
    RestResponse<ProductResponse> createSales(
            @RequestBody
            CreateSalesRequest createSalesRequest
    ){
        return new RestResponse<ProductResponse>().success(
                salesService.create(createSalesRequest)
        );
    }

}
