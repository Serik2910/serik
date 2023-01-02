package soap.start.serik.Utils;







import kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannel;

import javax.xml.ws.BindingProvider;

public class EsedoConnection {
    public static final String ESEDO_ENDPOINT = "http://195.12.113.7/bip-sync-wss-gost/";


    public static void setEndpointAddress(kz.bee.bip.SyncChannel.v10.Interfaces.ISyncChannel iSyncChannelPort){

        BindingProvider bindingProvider = (BindingProvider) iSyncChannelPort;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ESEDO_ENDPOINT);
    }
    public static void setEndpointAddressHED(ISyncChannel iSyncChannelPort){

        BindingProvider bindingProvider = (BindingProvider) iSyncChannelPort;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ESEDO_ENDPOINT);
    }

    public static void setEndpointAddressNSI(kz.nitec.unidic.binding2.ISyncChannel iSyncChannelPort){

        BindingProvider bindingProvider = (BindingProvider) iSyncChannelPort;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ESEDO_ENDPOINT);
    }

}
