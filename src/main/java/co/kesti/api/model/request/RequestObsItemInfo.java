package co.kesti.api.model.request;

import co.kesti.api.entity.ObsItemInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestObsItemInfo {
    @Id
    private String devModelId;
    private String obsItem;
    private String unitType;
    private LocalDateTime registeDt;

    public ObsItemInfo toObsItemInfo() {
        return ObsItemInfo.builder()
                .devModelId(devModelId)
                .obsItem(obsItem)
                .unitType(unitType)
                .registeDt(registeDt)
                .build();
    }
}
