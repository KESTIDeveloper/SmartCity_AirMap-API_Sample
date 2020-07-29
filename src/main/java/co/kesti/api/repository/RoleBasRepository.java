package co.kesti.api.repository;


import co.kesti.api.entity.RoleBas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleBasRepository extends JpaRepository<RoleBas, String> {
}
