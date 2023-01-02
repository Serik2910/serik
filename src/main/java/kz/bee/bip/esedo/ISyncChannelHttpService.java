
package kz.bee.bip.esedo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ISyncChannelHttpService",
        targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Interfaces",
        wsdlLocation = "file:/SyncChannelHttp_Service.wsdl")

public class ISyncChannelHttpService
    extends Service
{

    private final static URL ISYNCCHANNELHTTPSERVICE_WSDL_LOCATION;
    private final static WebServiceException ISYNCCHANNELHTTPSERVICE_EXCEPTION;
    private final static QName ISYNCCHANNELHTTPSERVICE_QNAME = new QName("http://bip.bee.kz/SyncChannel/v10/Interfaces", "ISyncChannelHttpService");

    //static {
      //  URL url = null;
    //    WebServiceException e = null;
    //    try {
    //        url = new URL("file:/Users/janalinov/Downloads/esedogw/src/main/resources/wsdl_consumer.wsdl");
    //    } catch (MalformedURLException ex) {
     //       e = new WebServiceException(ex);
     //   }
       // ISYNCCHANNELHTTPSERVICE_WSDL_LOCATION = url;
       // ISYNCCHANNELHTTPSERVICE_EXCEPTION = e;
    //}

    static {
        URL url = ISyncChannelHttpService.class.getResource("/wsdl/SyncChannel/v10/Interfaces/SyncChannelHttp_Service.wsdl");
        WebServiceException e = null;
        if (url == null) {
            e = new WebServiceException("Cannot find '/SyncChannelHttp_Service.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        ISYNCCHANNELHTTPSERVICE_WSDL_LOCATION = url;
        ISYNCCHANNELHTTPSERVICE_EXCEPTION = e;
    }

    public ISyncChannelHttpService() {
        super(__getWsdlLocation(), ISYNCCHANNELHTTPSERVICE_QNAME);
    }

    public ISyncChannelHttpService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ISYNCCHANNELHTTPSERVICE_QNAME, features);
    }

    public ISyncChannelHttpService(URL wsdlLocation) {
        super(wsdlLocation, ISYNCCHANNELHTTPSERVICE_QNAME);
    }

    public ISyncChannelHttpService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ISYNCCHANNELHTTPSERVICE_QNAME, features);
    }

    public ISyncChannelHttpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ISyncChannelHttpService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ISyncChannel
     */
    @WebEndpoint(name = "SyncChannelHttpPort")
    public ISyncChannel getSyncChannelHttpPort() {
        return super.getPort(new QName("http://bip.bee.kz/SyncChannel/v10/Interfaces", "SyncChannelHttpPort"), ISyncChannel.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ISyncChannel
     */
    @WebEndpoint(name = "SyncChannelHttpPort")
    public ISyncChannel getSyncChannelHttpPort(WebServiceFeature... features) {
        return super.getPort(
                new QName("http://bip.bee.kz/SyncChannel/v10/Interfaces/Binding2",
                "SyncChannelHttpPort"), ISyncChannel.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ISYNCCHANNELHTTPSERVICE_EXCEPTION!= null) {
            throw ISYNCCHANNELHTTPSERVICE_EXCEPTION;
        }
        return ISYNCCHANNELHTTPSERVICE_WSDL_LOCATION;
    }

}
