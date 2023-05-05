package soap.start.serik.service;

import soap.start.serik.models.DocOutgoingDTO;

import java.util.List;

public interface IDocOutgoingService {
    DocOutgoingDTO save(DocOutgoingDTO docOutgoingDTO);
    List<DocOutgoingDTO> getListOfDocOutgoing(String href);
}
