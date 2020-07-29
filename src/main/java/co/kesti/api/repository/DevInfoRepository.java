package co.kesti.api.repository;

import co.kesti.api.entity.DevInfo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DevInfoRepository extends  JpaRepository<DevInfo, String> {
}
