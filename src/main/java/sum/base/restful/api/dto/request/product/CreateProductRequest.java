package sum.base.restful.api.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sum.base.restful.api.entity.product.Product;
import sum.base.restful.api.util.GeneratorIdUtil;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotBlank
    private String productName;

    @Min(0)
    private Double productPrice;

    private String productDescription;

    public Product toEntity(String createdBy){
        Product entity = new Product(
                GeneratorIdUtil.GenerateId(),
                this.getProductName(),
                this.getProductPrice(),
                this.getProductDescription()
        );
        entity.setCreated(createdBy);
        return entity;
    }

}

