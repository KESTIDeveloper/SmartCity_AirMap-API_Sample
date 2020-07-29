package co.kesti.api.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="airmap", name="obs_item_info")
public class ObsItemInfo {

    @Id
    @Column(nullable = false)
    private String devModelId;
    private String obsItem;
    private String unitType;
    private LocalDateTime registeDt;
}
