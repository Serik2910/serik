package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.StateNewExDateDTO;
import soap.start.serik.models.StateProlongExDateDTO;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StateProlongExDateRepository extends JpaRepository<StateProlongExDateDTO, Long> {
    List<StateProlongExDateDTO> findAllByHref(String href);
}
