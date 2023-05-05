package soap.start.serik.configurations;



import kz.bee.bip.esedo.SyncChannelImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soap.start.serik.service.IxmlDsigUtil;
import soap.start.serik.service.SimbaseClientService;
import soap.start.serik.web_services.server.HelloServiceImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class WSConfig {
    private final Bus bus;
    private final SimbaseClientService service;
    private final IxmlDsigUtil dsigUtil;

    public WSConfig(Bus bus, SimbaseClientService service, IxmlDsigUtil dsigUtil) {

        this.bus = bus;
        this.service = service;
        this.dsigUtil = dsigUtil;
    }
    @Bean
    public Endpoint helloEndPoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
        endpoint.publish("/hello");
        return endpoint;
    }


    @Bean
    public Endpoint vshepEndPoint2(){
        EndpointImpl endpoint = new EndpointImpl(bus, new SyncChannelImpl(service, this.dsigUtil));
        endpoint.publish("/delivered");
        return endpoint;
    }
}
