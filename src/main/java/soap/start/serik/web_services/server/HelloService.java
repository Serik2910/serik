package soap.start.serik.web_services.server;

import javax.jws.*;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://serik.start.soap/", name = "Hello")
@HandlerChain(file = "/handler_validator.xml")
public interface HelloService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(
            localName = "sayHello",
            targetNamespace="http://serik.start.soap/",
            className = "soap.start.serik.SayHello"
    )
    @WebMethod(action = "urn:SayHello")
    @ResponseWrapper(
            localName = "sayHelloResponse",
            targetNamespace="http://serik.start.soap/",
            className = "soap.start.serik.SayHelloResponse")
    String sayHello(@WebParam(name = "name", targetNamespace = "") String name);
}
