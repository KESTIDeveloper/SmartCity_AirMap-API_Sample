package co.kesti.api.service;

import co.kesti.api.entity.RoleBas;
import co.kesti.api.error.ApplicationException;
import co.kesti.api.error.ResponseCode;
import co.kesti.api.model.request.RequestRoleBas;
import co.kesti.api.repository.RoleBasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class RoleBasService {

    private final RoleBasRepository roleBasRepository;

    public RoleBasService(RoleBasRepository roleBasRepository) {
        this.roleBasRepository = roleBasRepository;
    }

    public List<RoleBas> getRoleBasList() {
        return roleBasRepository.findAll();
    }

    public RoleBas getRoleBas(String roleId) {
        return roleBasRepository.findById(roleId)
                .orElseThrow(() -> new ApplicationException(
                        ResponseCode.RESOURCE_NOT_FOUND, "RoleBas not found" + roleId
                ));
    }

    public RoleBas createRoleBas(RequestRoleBas requestRoleBas) {
        RoleBas roleBas = requestRoleBas.toRoleBas();
        return roleBasRepository.save(roleBas);
    }

    @Transactional
    public RoleBas updateRoleBas(String roleId, RequestRoleBas requestRoleBas) {
        RoleBas roleBas = requestRoleBas.toRoleBas();
        return roleBasRepository.save(roleBas);
    }

    @Transactional
    public void deleteRoleBas(String roleId) {
        RoleBas roleBas = getRoleBas(roleId);
        roleBasRepository.delete(roleBas);
    }
}
