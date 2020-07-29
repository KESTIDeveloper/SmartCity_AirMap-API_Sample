package co.kesti.api.repository;

import co.kesti.api.entity.ObsItemInfo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ObsItemInfoRepository extends JpaRepository<ObsItemInfo, String> {
}
