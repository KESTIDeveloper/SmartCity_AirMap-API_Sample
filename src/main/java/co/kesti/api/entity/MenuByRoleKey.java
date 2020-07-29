package co.kesti.api.entity;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuByRoleKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Integer menuId;

    @Column(nullable = false)
    private String roleId;

}
