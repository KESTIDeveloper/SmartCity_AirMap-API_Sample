package co.kesti.api.service;

import co.kesti.api.entity.MenuByRoleRel;
import co.kesti.api.repository.MenuByRoleRelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MenuByRoleService {

    private final MenuByRoleRelRepository menuByRoleRelRepository;

    public MenuByRoleService(MenuByRoleRelRepository menuByRoleRelRepository) { this.menuByRoleRelRepository = menuByRoleRelRepository; }

    public List<MenuByRoleRel> getMenuByRoleRelList() {
        return menuByRoleRelRepository.findAll();
    }
}
