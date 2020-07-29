package co.kesti.api.service;

import co.kesti.api.entity.DevInfo;
import co.kesti.api.error.ApplicationException;
import co.kesti.api.error.ResponseCode;
import co.kesti.api.model.request.RequestDevInfo;
import co.kesti.api.repository.DevInfoRepository;
import co.kesti.api.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class DevInfoService {

    private final DevInfoRepository devInfoRepository;

    public DevInfoService(DevInfoRepository devInfoRepository) { this.devInfoRepository = devInfoRepository; }

    public List<DevInfo> getDevInfoList() { return devInfoRepository.findAll(); }

    public DevInfo getDevInfo(String devModelId) {
        return devInfoRepository.findById(devModelId)
                .orElseThrow(() -> new ApplicationException(
                        ResponseCode.RESOURCE_NOT_FOUND, "DevInfo not found" + devModelId));
    }

    @Transactional
    public DevInfo updateDevInfo(String devModelId, RequestDevInfo requestDevInfo) {
        DevInfo devInfo = requestDevInfo.toDevInfo();
        log.info("{}", JsonUtils.toPrettyString(devModelId));
        return devInfoRepository.save(devInfo);
    }

    public DevInfo createDevInfo(RequestDevInfo requestDevInfo) {
        DevInfo devInfo = requestDevInfo.toDevInfo();
        log.info("{}", JsonUtils.toPrettyString(devInfo));
        return devInfoRepository.save(devInfo);
    }
}
