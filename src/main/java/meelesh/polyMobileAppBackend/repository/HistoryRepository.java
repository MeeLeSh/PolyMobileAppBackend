package meelesh.polyMobileAppBackend.repository;

import meelesh.polyMobileAppBackend.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByUsername(String username);

}
