package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.DocSectionDTO;
import soap.start.serik.models.StateExecutionDTO;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface StateExecutionRepository extends JpaRepository<StateExecutionDTO, Long> {
    List<StateExecutionDTO> findAllByHref(String href);
}
