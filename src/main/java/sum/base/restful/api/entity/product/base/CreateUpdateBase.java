package sum.base.restful.api.entity.product.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CreateUpdateBase {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void setCreated(String createdBy){
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    public void setUpdated(String updatedBy){
        this.updatedBy = updatedBy;
        this.updatedAt = LocalDateTime.now();
    }

}
