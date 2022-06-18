package sum.base.restful.api.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sum.base.restful.api.entity.product.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String productId;

    private String productName;

    private Double productPrice;

    private String productDescription;

    public static ProductResponse fromEntity(Product entity){
        return new ProductResponse(
            entity.getProductId(),
            entity.getProductName(),
            entity.getProductPrice(),
            entity.getProductDescription()
        );
    }

}
