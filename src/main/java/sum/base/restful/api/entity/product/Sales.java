package sum.base.restful.api.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @Column(name = "sales_id")
    private String salesId;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "total")
    private Double total;

}
