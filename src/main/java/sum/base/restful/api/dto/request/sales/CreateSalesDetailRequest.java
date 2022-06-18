package sum.base.restful.api.dto.request.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSalesDetailRequest {

    @NotBlank
    private String productId;

}
