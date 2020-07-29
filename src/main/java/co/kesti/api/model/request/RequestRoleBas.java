package co.kesti.api.model.request;

import co.kesti.api.entity.RoleBas;
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
public class RequestRoleBas {
    @Id
    private String roleId;
    private String roleNm;
    private String rmark;
    private String delYn;
    private String cretrId;
    private LocalDateTime cretDt;
    private String amdrId;
    private LocalDateTime amdDt;
    private Integer userRoleClasCd;

    public RoleBas toRoleBas() {
        return RoleBas.builder()
                .roleId(roleId)
                .roleNm(roleNm)
                .rmark(rmark)
                .delYn(delYn)
                .cretrId(cretrId)
                .cretDt(cretDt)
                .amdrId(amdrId)
                .amdDt(amdDt)
                .userRoleClasCd(userRoleClasCd)
                .build();
    }
}
