package co.kesti.api.controller;

import co.kesti.api.entity.MenuByRoleRel;
import co.kesti.api.model.response.ApiResponse;
import co.kesti.api.service.MenuByRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/AIRMAP/v0.9")
@Api(value = "/AIRMAP/v0.9", tags = "역할별 메뉴(MenuByRoleRel)", description = "역할별 메뉴 API" )
public class MenuByRoleRelController {

    private MenuByRoleService menuByRoleService;

    @ApiOperation(value = "역할별 메뉴 권한 조회", notes = "역할별 메뉴 권한 정보 전체를 조회한다.")
    @GetMapping("/menuByRoleRel")
    public ApiResponse getMenuByRoleRelList() {
        List<MenuByRoleRel> menuByRoleRel = menuByRoleService.getMenuByRoleRelList();
        return ApiResponse.ok(menuByRoleRel);
    }
}
