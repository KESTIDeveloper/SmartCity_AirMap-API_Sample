package co.kesti.api.entity;

import lombok.*;

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
@Table(schema="airmap", name="role_bas")
public class RoleBas {
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
}
