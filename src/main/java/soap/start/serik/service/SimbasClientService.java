package soap.start.serik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soap.start.serik.models.SimbaseClient;
import soap.start.serik.repositories.SimbaseClientRepository;

@Service
public class SimbasClientService implements ISimbaseClientService{

    private final SimbaseClientRepository repository;

    public SimbasClientService(SimbaseClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public SimbaseClient findFirst(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SimbaseClient save(SimbaseClient client) {
        return repository.save(client);
    }
}
