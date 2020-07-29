package co.kesti.api.service;

import co.kesti.api.entity.ObsItemInfo;
import co.kesti.api.error.ApplicationException;
import co.kesti.api.error.ResponseCode;
import co.kesti.api.model.request.RequestObsItemInfo;
import co.kesti.api.repository.ObsItemInfoRepository;
import co.kesti.api.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ObsItemInfoService {

    private final ObsItemInfoRepository obsItemInfoRepository;

    public ObsItemInfoService(ObsItemInfoRepository obsItemInfoRepository) {this.obsItemInfoRepository = obsItemInfoRepository;}

    public List<ObsItemInfo> getObsItemInfoList() {
        return obsItemInfoRepository.findAll();
    }

    public ObsItemInfo getObsItemInfoOrThrow(String devModelId) {
        return obsItemInfoRepository.findById(devModelId)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "ObsItemInfo not found: "+ devModelId));
    }

    public ObsItemInfo getObsItemInfo(String devModelId) {
        return obsItemInfoRepository.findById(devModelId)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "ObsItemInfo not found" + devModelId));
    }

    public ObsItemInfo createObstItemInfo(RequestObsItemInfo requestObsItemInfo) {
        ObsItemInfo obsItemInfo = requestObsItemInfo.toObsItemInfo();
        log.info("{}", JsonUtils.toPrettyString(obsItemInfo));
        return obsItemInfoRepository.save(obsItemInfo);
    }

    @Transactional
    public ObsItemInfo updateObsItemInfo(String devModelId, RequestObsItemInfo requestObsItemInfo) {
        ObsItemInfo obsItemInfo = requestObsItemInfo.toObsItemInfo();
        obsItemInfo.setDevModelId(devModelId);
        log.info("{}", JsonUtils.toPrettyString(devModelId));
        return obsItemInfoRepository.save(obsItemInfo);
    }

    @Transactional
    public void deleteObstItemInfo(String devModelId) {
        ObsItemInfo obsItemInfo = getObsItemInfoOrThrow(devModelId);
        obsItemInfoRepository.delete(obsItemInfo);
    }
}
