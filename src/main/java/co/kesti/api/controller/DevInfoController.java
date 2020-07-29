package co.kesti.api.controller;

import co.kesti.api.entity.DevInfo;
import co.kesti.api.model.request.RequestDevInfo;
import co.kesti.api.model.response.ApiResponse;
import co.kesti.api.service.DevInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/AIRMAP/v0.9")
@Api(value = "/AIRMAP/v0.9", tags = "측정 기기(DevInfo)", description = "측정 기기 API")
public class DevInfoController {

    private final DevInfoService devInfoService;

    public DevInfoController(DevInfoService devInfoService) { this.devInfoService = devInfoService; }

    @ApiOperation(value = "측정 기기 조회", notes = "측정 기기 전체를 조회한다.")
    @GetMapping("/devInfo")
    public ApiResponse getDevInfoList() {
        List<DevInfo> devInfo = devInfoService.getDevInfoList();
        return ApiResponse.ok(devInfo);
    }

    @ApiOperation(value = "측정 기기 dev 조회", notes = "측정 기기 전체를 조회한다.")
    @GetMapping("devInfo/{Id}")
    public ApiResponse getDevInfo(@ApiParam(value = "측정기 모델 Id", required = true)
                                  @PathVariable(value = "Id") String devModelId) {
        DevInfo devInfo = devInfoService.getDevInfo(devModelId);
        return ApiResponse.ok(devInfo);
    }

    @ApiOperation(value = "측정 기기 정보 갱신", notes = "측정 기기 정보를 갱신한다.")
    @PutMapping("/devInfo/{Id}")
    public ApiResponse updateDevInfo(
                                     @ApiParam(value = "측정 기기 정보 Id", required = true)
                                     @PathVariable(value = "Id") String devModelId,
                                     @RequestBody RequestDevInfo requestDevInfo) {
        DevInfo devInfo = devInfoService.updateDevInfo(devModelId, requestDevInfo);
        return ApiResponse.ok(devInfo);
    };

    @ApiOperation(value = "측정 항목 정보 추가", notes = "측정 기기 정보를 추가한다.")
    @PostMapping("/devInfo")
    public ApiResponse createDevInfo(@RequestBody RequestDevInfo requestDevInfo) {
        DevInfo devInfo = devInfoService.createDevInfo(requestDevInfo);
        return ApiResponse.ok(devInfo);
    }
}
