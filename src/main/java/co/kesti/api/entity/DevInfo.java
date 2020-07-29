package co.kesti.api.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="airmap", name="dev_info")
public class DevInfo {
    private String devName;
    private String devUserName;
    @Id
    @Column(nullable = false)
    private String devModelId;
    private String devPassword;
    private String gatewayConnId;
    private String devType;
    private String manufacturerName;
    private String protocolType;
    private String protocolRule;
    private Float latitVal;
    private Float lngitVal;
    private String connStatus;
    private String liveStatus;
    private Integer mbrSeq;
}
