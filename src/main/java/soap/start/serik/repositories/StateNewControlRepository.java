package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.DocSectionDTO;
import soap.start.serik.models.StateNewControlDTO;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StateNewControlRepository extends JpaRepository<StateNewControlDTO, Long> {
    List<StateNewControlDTO> findAllByHref(String href);
}
