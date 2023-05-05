package soap.start.serik.service;

import org.springframework.stereotype.Service;
import soap.start.serik.models.*;
import soap.start.serik.repositories.*;

@Service
public class SimbaseClientService implements ISimbaseClientService{

    private final SimbaseClientRepository simbaseClientRepository;
    private final DocOutgoingRepository docOutgoingRepository;
    private final DocAppealRepository docAppealRepository;
    private final StateDeliveredRepository stateDeliveredRepository;
    private final StateRegisteredRepository stateRegisteredRepository;
    private final DocOLRepository docOLRepository;
    private final StateNotValidRepository stateNotValidRepository;
    private final DocSectionRepository docSectionRepository;
    private final StateExecutionRepository stateExecutionRepository;
    private final StateFinishedRepository stateFinishedRepository;

    public SimbaseClientService(
            SimbaseClientRepository simbaseClientRepository,
            DocOutgoingRepository docOutgoingRepository,
            DocAppealRepository docAppealRepository,
            StateDeliveredRepository stateDeliveredRepository,
            StateRegisteredRepository stateRegisteredRepository,
            DocOLRepository docOLRepository,
            StateNotValidRepository stateNotValidRepository,
            DocSectionRepository docSectionRepository,
            StateExecutionRepository stateExecutionRepository,
            StateFinishedRepository stateFinishedRepository) {
        this.simbaseClientRepository = simbaseClientRepository;
        this.docOutgoingRepository = docOutgoingRepository;
        this.docAppealRepository = docAppealRepository;
        this.stateDeliveredRepository = stateDeliveredRepository;
        this.stateRegisteredRepository = stateRegisteredRepository;
        this.docOLRepository = docOLRepository;
        this.stateNotValidRepository = stateNotValidRepository;
        this.docSectionRepository = docSectionRepository;
        this.stateExecutionRepository = stateExecutionRepository;
        this.stateFinishedRepository = stateFinishedRepository;
    }


    @Override
    public SimbaseClient findFirstClient(Long id) {
        return simbaseClientRepository.findById(id).orElse(null);
    }

    @Override
    public SimbaseClient saveClient(SimbaseClient client) {
        return simbaseClientRepository.save(client);
    }

    @Override
    public DocOutgoingDTO saveDocOutgoing(DocOutgoingDTO docOutgoingDTO) {
        return docOutgoingRepository.save(docOutgoingDTO);
    }

    @Override
    public DocAppealDTO saveDocAppeal(DocAppealDTO docAppealDTO) {
        return docAppealRepository.save(docAppealDTO);
    }

    @Override
    public StateDeliveredDTO saveStateDelivered(StateDeliveredDTO stateDeliveredDTO) {
        return stateDeliveredRepository.save(stateDeliveredDTO);
    }

    @Override
    public StateRegisteredDTO saveStateRegistered(StateRegisteredDTO stateRegisteredDTO) {
        return stateRegisteredRepository.save(stateRegisteredDTO);
    }

    @Override
    public StateNotValidDTO saveStateNotValid(StateNotValidDTO stateNotValidDTO) {
        return stateNotValidRepository.save(stateNotValidDTO);
    }

    @Override
    public DocSectionDTO saveDocSection(DocSectionDTO docSectionDTO) {
        return docSectionRepository.save(docSectionDTO);
    }

    @Override
    public StateExecutionDTO saveStateExecution(StateExecutionDTO stateExecutionDTO) {
        return stateExecutionRepository.save(stateExecutionDTO);
    }

    @Override
    public StateFinishedDTO saveStateFinished(StateFinishedDTO stateFinishedDTO) {
        return stateFinishedRepository.save(stateFinishedDTO);
    }

    @Override
    public DocOLDTO saveDocOL(DocOLDTO docOLDTO) {
        return docOLRepository.save(docOLDTO);
    }


}
