package co.kesti.api.controller;

import co.kesti.api.entity.ObsItemInfo;
import co.kesti.api.model.request.RequestObsItemInfo;
import co.kesti.api.model.response.ApiResponse;
import co.kesti.api.service.ObsItemInfoService;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/AIRMAP/v0.9")
@Api(value = "/AIRMAP/v0.9", tags = "측정 항목(ObsItemInfo)", description = "측정 항목 API")
public class ObsItemInfoController {

    private final ObsItemInfoService obsItemInfoService;

    public ObsItemInfoController(ObsItemInfoService obsItemInfoService) { this.obsItemInfoService = obsItemInfoService; }

    @ApiOperation(value = "측정 항목 정보 전체 조회")
    @GetMapping("/obsItemInfo")
    public ApiResponse getObsItemInfoList() {
        List<ObsItemInfo> obsItemInfo = obsItemInfoService.getObsItemInfoList();
        return ApiResponse.ok(obsItemInfo);
    }

   @ApiOperation(value = "측정 항목 정보 devModelId 검색 조회")
   @GetMapping("/obsItemInfo/{Id}")
    public ApiResponse getObsItemInfo(@ApiParam(value = "측정기 모델 Id", required = true)
                                      @PathVariable(value= "Id") String devModelId) {

        ObsItemInfo obsItemInfo = obsItemInfoService.getObsItemInfo(devModelId);
        return ApiResponse.ok(obsItemInfo);
    }

    @ApiOperation(value = "측정 항목 정보 추가")
    @PostMapping("/obsItemInfo")
    public ApiResponse createObsItemInfo(@RequestBody RequestObsItemInfo requestObsItemInfo) {
        ObsItemInfo obsItemInfo = obsItemInfoService.createObstItemInfo(requestObsItemInfo);
        return ApiResponse.ok(obsItemInfo);
    }

    @ApiOperation(value = "측정 항목 정보 갱신")
    @PutMapping("/obsItemInfo/{Id}")
    public ApiResponse updateObsItemInfo(
                                         @ApiParam(value = "측정기 모델 Id", required = true)
                                         @PathVariable(value= "Id") String devModelId,
                                         @RequestBody RequestObsItemInfo requestObsItemInfo) {
        ObsItemInfo obsItemInfo = obsItemInfoService.updateObsItemInfo(devModelId, requestObsItemInfo);
        return ApiResponse.ok(obsItemInfo);
    }

    @ApiOperation(value = "측정 항목 정보 삭제")
    @DeleteMapping("/obsItemInfo/{Id}")
    public ApiResponse deleteObsItemInfo(@ApiParam(value = "측정기 모델 Id", required = true)
                                         @PathVariable(value = "Id") String devModelId) {
        obsItemInfoService.deleteObstItemInfo(devModelId);
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }
}
