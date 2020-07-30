package co.kesti.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="airmap", name="tb_com_rgn_bas")
public class TbComRgnBas {

    private String sidoNm;
    private String sggNm;
    private String eupMyunDongNm;

    @Id
    private String sidoCd;
    private String liNm;
    private String cretrId;
    private LocalTime cretDt;
}
