package soap.start.serik.web_services.server;


import javax.jws.WebService;

@WebService(
        serviceName = "HelloService",
        portName = "HelloPort",
        targetNamespace = "http://serik.start.soap/",
        endpointInterface = "soap.start.serik.web_services.server.HelloService"
)
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String name) {

        return "Hi "+name;
    }
}
