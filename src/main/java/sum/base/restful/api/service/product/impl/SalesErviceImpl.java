package sum.base.restful.api.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum.base.restful.api.dto.request.sales.CreateSalesRequest;
import sum.base.restful.api.entity.product.Sales;
import sum.base.restful.api.entity.product.SalesDetail;
import sum.base.restful.api.repository.product.SalesDetailRepository;
import sum.base.restful.api.repository.product.SalesRepository;
import sum.base.restful.api.service.product.SalesService;
import sum.base.restful.api.util.GeneratorIdUtil;
import sum.base.restful.api.util.ValidationUtil;
import java.util.*;

@Service
public class SalesErviceImpl implements SalesService {

    private final SalesRepository salesRepository;
    private final SalesDetailRepository salesDetailRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public SalesErviceImpl(
            SalesRepository salesRepository,
            SalesDetailRepository salesDetailRepository,
            ValidationUtil validationUtil
    ) {
        this.salesRepository = salesRepository;
        this.salesDetailRepository = salesDetailRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public String create(CreateSalesRequest createSalesRequest) {
        validationUtil.validate(createSalesRequest);

        Sales sales = new Sales();
        sales.setSalesId(GeneratorIdUtil.GenerateId());
        sales.setInvoiceNumber(createSalesRequest.getInvoiceNumber());
        sales.setTotal(createSalesRequest.getTotal());
        salesRepository.save(sales);

        List<SalesDetail> salesDetails = new ArrayList<>();
        createSalesRequest.getSalesDetails().forEach((item) ->
                salesDetails.add(
                        new SalesDetail(
                                GeneratorIdUtil.GenerateId(),
                                item.getProductId(),
                                sales
                        )
                )
        );


        return sales.toString()+ salesDetailRepository.saveAll(salesDetails).toString();
    }
}
