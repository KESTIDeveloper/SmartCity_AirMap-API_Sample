package co.kesti.api.model.request;

import co.kesti.api.entity.MenuByRoleKey;
import co.kesti.api.entity.MenuByRoleRel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestMenuByRoleRel {

    @NotBlank
    private Integer menuId;

    @NotBlank
    private String roleId;

    private Integer odrg;
    private String cretrId;
    private LocalTime cretDt;
    private String amdrId;
    private String amdDt;

    @JsonIgnore
    public MenuByRoleKey getMenuByRoleKey() {
        return MenuByRoleKey.builder()
                .menuId(menuId)
                .roleId(roleId)
                .build();
    }

    public MenuByRoleRel toMenuByRoleRel() {
        return MenuByRoleRel.builder()
                .menuByRoleKey(getMenuByRoleKey())
                .odrg(odrg)
                .cretDt(cretDt)
                .cretDt(cretDt)
                .amdrId(amdrId)
                .amdDt(amdDt)
                .build();
    }
}
