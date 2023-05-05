package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.start.serik.models.DocOLDTO;
import soap.start.serik.models.StateDeliveredDTO;

import java.util.List;

public interface DocOLRepository extends JpaRepository<DocOLDTO, Long> {
    List<DocOLDTO> findAllByHref(String href);
}
