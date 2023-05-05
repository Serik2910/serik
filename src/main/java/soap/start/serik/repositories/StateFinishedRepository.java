package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.StateExecutionDTO;
import soap.start.serik.models.StateFinishedDTO;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StateFinishedRepository extends JpaRepository<StateFinishedDTO, Long> {
    List<StateFinishedDTO> findAllByHref(String href);
}
