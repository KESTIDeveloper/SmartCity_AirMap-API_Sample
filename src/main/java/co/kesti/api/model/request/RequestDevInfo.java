package co.kesti.api.model.request;

import co.kesti.api.entity.DevInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDevInfo {

    private String devName;
    private String devUserName;
    @Id
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

    public DevInfo toDevInfo() {
        return DevInfo.builder()
                .devName(devName)
                .devUserName(devUserName)
                .devModelId(devModelId)
                .devPassword(devPassword)
                .gatewayConnId(gatewayConnId)
                .devType(devType)
                .manufacturerName(manufacturerName)
                .protocolType(protocolType)
                .protocolRule(protocolRule)
                .latitVal(latitVal)
                .lngitVal(lngitVal)
                .connStatus(connStatus)
                .liveStatus(liveStatus)
                .build();
    }
}
