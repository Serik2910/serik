package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.DocSectionDTO;
import soap.start.serik.models.StateDeliveredDTO;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface DocSectionRepository extends JpaRepository<DocSectionDTO, Long> {
    List<DocSectionDTO> findAllByHref(String href);
}
