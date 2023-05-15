package soap.start.serik.service;

import soap.start.serik.models.*;

public interface ISimbaseClientService {
    SimbaseClient findFirstClient(Long id);
    SimbaseClient saveClient(SimbaseClient client);

    DocOutgoingDTO saveDocOutgoing(DocOutgoingDTO docOutgoingDTO);

    DocAppealDTO saveDocAppeal(DocAppealDTO docAppealDTO);

    StateDeliveredDTO saveStateDelivered(StateDeliveredDTO stateDeliveredDTO);
    StateRegisteredDTO saveStateRegistered(StateRegisteredDTO stateRegisteredDTO);
    StateNotValidDTO saveStateNotValid(StateNotValidDTO stateNotValidDTO);
    DocSectionDTO saveDocSection(DocSectionDTO docSectionDTO);

    StateExecutionDTO saveStateExecution(StateExecutionDTO stateExecutionDTO);

    StateFinishedDTO saveStateFinished(StateFinishedDTO stateFinishedDTO);
    StateNewControlDTO saveStateNewControl(StateNewControlDTO stateNewControlDTO);
    StateNewExDateDTO saveStateNewExDate(StateNewExDateDTO stateNewExDateDTO);
    StateProlongExDateDTO saveStateProlongExDate(StateProlongExDateDTO stateProlongExDateDTO);
    StateTakeOfControlDTO saveStateTakeOfControl(StateTakeOfControlDTO stateTakeOfControlDTO);

    DocOLDTO saveDocOL(DocOLDTO docOLDTO);

}
