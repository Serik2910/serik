package soap.start.serik.Utils;


import kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannel;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import javax.xml.ws.BindingProvider;

import static soap.start.serik.models.Const.ESEDO_ENDPOINT;

public class EsedoConnection {

    public static void setEndpointAddress(kz.bee.bip.SyncChannel.v10.Interfaces.ISyncChannel iSyncChannelPort){

        BindingProvider bindingProvider = (BindingProvider) iSyncChannelPort;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ESEDO_ENDPOINT);
        Client client = ClientProxy.getClient(iSyncChannelPort);
        HTTPConduit httpConduit = (HTTPConduit)client.getConduit();
        TLSClientParameters tlsClientParameters = new TLSClientParameters();
        tlsClientParameters.setDisableCNCheck(true);
        httpConduit.setTlsClientParameters(tlsClientParameters);
    }
    public static void setEndpointAddressHED(ISyncChannel iSyncChannelPort){

        BindingProvider bindingProvider = (BindingProvider) iSyncChannelPort;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ESEDO_ENDPOINT);
        Client client = ClientProxy.getClient(iSyncChannelPort);
        HTTPConduit httpConduit = (HTTPConduit)client.getConduit();
        TLSClientParameters tlsClientParameters = new TLSClientParameters();
        tlsClientParameters.setDisableCNCheck(true);
        httpConduit.setTlsClientParameters(tlsClientParameters);
    }

    public static void setEndpointAddressNSI(kz.nitec.unidic.binding2.ISyncChannel iSyncChannelPort){

        BindingProvider bindingProvider = (BindingProvider) iSyncChannelPort;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ESEDO_ENDPOINT);
        Client client = ClientProxy.getClient(iSyncChannelPort);
        HTTPConduit httpConduit = (HTTPConduit)client.getConduit();
        TLSClientParameters tlsClientParameters = new TLSClientParameters();
        tlsClientParameters.setDisableCNCheck(true);
        httpConduit.setTlsClientParameters(tlsClientParameters);
    }

}
