package soap.start.serik.configurations;



import kz.bee.bip.esedo.SyncChannelImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import soap.start.serik.models.Const;
import soap.start.serik.web_services.server.HelloServiceImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class WSConfig {
    private final Bus bus;

    public WSConfig(Bus bus) {

        this.bus = bus;
    }
    @Bean
    public Endpoint helloEndPoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
        endpoint.publish("/hello");
        return endpoint;
    }
    @Value("${p12.file.location}")
    private String location;
    @Value("${p12.file.password}")
    private String pass;
    @Value("${p12.file.alias}")
    private String alias;
    @Value("${p12.file.type}")
    private String type;

    @Bean
    public void fillConsts(){
        Const.addConst(Const.STORE_FILE_LOCATION, location);
        Const.addConst(Const.STORE_FILE_PASS, pass);
        Const.addConst(Const.STORE_TYPE, type);
        Const.addConst(Const.STORE_ALIAS, alias);
    }


    @Bean
    public Endpoint vshepEndPoint2(){
        EndpointImpl endpoint = new EndpointImpl(bus, new SyncChannelImpl());
        endpoint.publish("/sync_channel");
        return endpoint;
    }
}
