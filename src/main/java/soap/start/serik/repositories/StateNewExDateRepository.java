package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.DocSectionDTO;
import soap.start.serik.models.StateNewExDateDTO;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StateNewExDateRepository extends JpaRepository<StateNewExDateDTO, Long> {
    List<StateNewExDateDTO> findAllByHref(String href);
}

