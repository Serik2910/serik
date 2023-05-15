package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.StateProlongExDateDTO;
import soap.start.serik.models.StateTakeOfControlDTO;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface StateTakeOfControlRepository extends JpaRepository<StateTakeOfControlDTO, Long> {
    List<StateTakeOfControlDTO> findAllByHref(String href);
}
