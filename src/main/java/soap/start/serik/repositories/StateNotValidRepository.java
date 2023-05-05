package soap.start.serik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.StateNotValidDTO;
import soap.start.serik.models.StateRegisteredDTO;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StateNotValidRepository extends JpaRepository<StateNotValidDTO, Long> {
    List<StateNotValidDTO> findAllByHref(String href);
}
