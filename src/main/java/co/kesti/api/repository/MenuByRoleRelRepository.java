package co.kesti.api.repository;

import co.kesti.api.entity.MenuByRoleKey;
import co.kesti.api.entity.MenuByRoleRel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuByRoleRelRepository extends JpaRepository<MenuByRoleRel, MenuByRoleKey> {
}
