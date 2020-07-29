package co.kesti.api.controller;

import co.kesti.api.entity.RoleBas;
import co.kesti.api.model.request.RequestRoleBas;
import co.kesti.api.model.response.ApiResponse;
import co.kesti.api.service.RoleBasService;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
@Api(value = "/AIRMAP/v0.9", tags = "역할 기본(RoleBas)", description = "역할 기본 API")
public class RoleBasController {

    private final RoleBasService roleBasService;

    public RoleBasController(RoleBasService roleBasService) { this.roleBasService = roleBasService; }

    @ApiOperation(value = "역할 기본")
    @GetMapping("/roleBas")
    public ApiResponse getRoleBasList() {
        List<RoleBas> roleBas = roleBasService.getRoleBasList();
        return ApiResponse.ok(roleBas);
    }

    @ApiOperation(value = "역할 기본 RoleBasId 조회", notes = "역할 기본 전체를 조회한다.")
    @GetMapping("roleBas/{Id}")
    public ApiResponse getRoleBas(@ApiParam(value = "역할 Id", required = true)
                                  @PathVariable(value = "Id") String roleId) {
        RoleBas roleBas = roleBasService.getRoleBas(roleId);
        return ApiResponse.ok(roleBas);
    }

    @ApiOperation(value = "역할 정보 추가")
    @PostMapping("/roleBas")
    public ApiResponse createObstItemInfo(@RequestBody RequestRoleBas requestRoleBas) {
        RoleBas roleBas = roleBasService.createRoleBas(requestRoleBas);
        return ApiResponse.ok(roleBas);
    }


    @ApiOperation(value = "역할 정보 갱신")
    @PutMapping("/roleBas/{Id}")
    public ApiResponse updateRoleBas(
            @ApiParam(value = "역할 Id", required = true)
            @PathVariable(value= "Id") String roleId,
            @RequestBody RequestRoleBas requestRoleBas) {
        RoleBas roleBas = roleBasService.updateRoleBas(roleId, requestRoleBas);
        return ApiResponse.ok(roleBas);
    }

    @ApiOperation(value = "역할 정보 삭제")
    @DeleteMapping("/roleBas/{Id}")
    public ApiResponse deleteRoleBas(@ApiParam(value = "역할 Id", required = true)
                                          @PathVariable(value = "Id") String roleId) {
        roleBasService.deleteRoleBas(roleId);
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }
}
