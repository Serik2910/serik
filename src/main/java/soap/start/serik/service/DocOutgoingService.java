package soap.start.serik.service;

import org.springframework.stereotype.Service;
import soap.start.serik.models.DocOutgoingDTO;
import soap.start.serik.repositories.DocOutgoingRepository;

import java.util.List;

@Service
public class DocOutgoingService implements IDocOutgoingService{
    private DocOutgoingRepository repository;

    public DocOutgoingService(DocOutgoingRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean save(DocOutgoingDTO docOutgoingDTO) {
        return false;
    }

    @Override
    public List<DocOutgoingDTO> getListOfDocOutgoing(String href) {
        return null;
    }
}
