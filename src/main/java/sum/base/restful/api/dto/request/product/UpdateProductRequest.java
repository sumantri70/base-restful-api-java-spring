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
public class UpdateProductRequest {

    @NotBlank
    private String productId;

    @NotBlank
    private String productName;

    @Min(0)
    private Double productPrice;

    private String productDescription;

    public Product toEntity(Product entity, String updatedBy){
        entity.setProductName(this.getProductName());
        entity.setProductPrice(this.getProductPrice());
        entity.setProductDescription(this.getProductDescription());
        entity.setUpdated(updatedBy);
        return entity;
    }

}
