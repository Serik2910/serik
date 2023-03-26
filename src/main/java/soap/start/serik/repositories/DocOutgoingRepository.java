package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.DocOutgoingDTO;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DocOutgoingRepository extends JpaRepository<DocOutgoingDTO, Long> {
    List<DocOutgoingDTO> findAllByHref(String href);
}
