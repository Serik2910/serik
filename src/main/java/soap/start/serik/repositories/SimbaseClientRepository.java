package soap.start.serik.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soap.start.serik.models.SimbaseClient;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SimbaseClientRepository extends CrudRepository<SimbaseClient, Long> {

}
