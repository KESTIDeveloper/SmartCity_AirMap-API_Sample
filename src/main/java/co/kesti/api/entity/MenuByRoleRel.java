package co.kesti.api.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="airmap", name="menu_by_role_rel", uniqueConstraints = @UniqueConstraint(columnNames = {"menuId" ,"roleId"}))
public class MenuByRoleRel {

    @EmbeddedId
    private MenuByRoleKey menuByRoleKey;

    private Integer odrg;
    private String cretrId;
    private LocalTime cretDt;
    private String amdrId;
    private String amdDt;
}
