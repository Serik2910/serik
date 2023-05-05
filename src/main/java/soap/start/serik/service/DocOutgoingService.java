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
    public DocOutgoingDTO save(DocOutgoingDTO docOutgoingDTO) {

        return this.repository.save(docOutgoingDTO);
    }

    @Override
    public List<DocOutgoingDTO> getListOfDocOutgoing(String href) {
        return null;
    }
}
