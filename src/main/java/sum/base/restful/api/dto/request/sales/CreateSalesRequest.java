package sum.base.restful.api.dto.request.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sum.base.restful.api.entity.product.SalesDetail;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSalesRequest {

    @NotBlank
    private String invoiceNumber;

    @Min(0)
    private Double total;

    @NotNull
    private List<SalesDetail> salesDetails;

    class CreateSalesDetail {

        @NotBlank
        private String productId;

    }

}
