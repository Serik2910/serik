package soap.start.serik.service;

import soap.start.serik.models.SimbaseClient;

public interface ISimbaseClientService {
    SimbaseClient findFirst(Long id);

    SimbaseClient save(SimbaseClient client);

}
