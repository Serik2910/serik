package kz.bee.bip.esedo;

import kz.bee.bip.SyncChannel.v10.Types.SendMessageResponse;
import kz.bee.bip.esedo.wsshandler.WSSSignHandle;
import kz.bee.bip.esedo.wsshandler.WSSign;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.jws.HandlerChain;
import javax.management.Query;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.handler.Handler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;



public class ClientEsedo {
    private static final Logger LOGGER = LogManager.getLogger(ClientEsedo.class);

    @SuppressWarnings("all")
    public void setEndpointAddress(Object port, String address, List<Handler> handlers) {
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
        bp.getBinding().setHandlerChain(handlers);
    }

    public void setEndpointAddress(Object port, String address) {
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }

    @SuppressWarnings("all")
    /*public kz.bee.bip.SyncChannel.v10.Types.response.SyncSendMessageResponse syncSendMessageResponse(kz.bee.bip
    .SyncChannel.v10.Types.request.SyncSendMessageRequest request, List<Handler> handlers) throws Exception, kz.bee.bip.SyncChannel.v10.Types.SendMessageSendMessageFaultMsg {
        kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannel itc =
                new kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannelHttpService().getSyncChannelHttpPort();
        kz.bee.bip.SyncChannel.v10.Types.response.SyncSendMessageResponse syncSendMessageResponse = null;
        try {
            setEndpointAddress(itc, "http://195.12.113.7/bip-sync-wss-gost/", handlers);
            SendMessageResponse sendMessageResponse = new SendMessageResponse();
            sendMessageResponse.setResponse(syncSendMessageResponse);
            syncSendMessageResponse = itc.sendMessage(request);
        } catch (kz.bee.bip.SyncChannel.v10.Interfaces.binding2.SendMessageSendMessageFaultMsg sendMessageSendMessageFaultMsg)
        {
            LOGGER.getLogger(sendMessageSendMessageFaultMsg.getFaultInfo().getErrorMessage());
            LOGGER.getLogger(sendMessageSendMessageFaultMsg.getMessage());
            LOGGER.getLogger(sendMessageSendMessageFaultMsg.getLocalizedMessage());
            LOGGER.getLogger(sendMessageSendMessageFaultMsg.getFaultInfo().getErrorData());
            LOGGER.getLogger(sendMessageSendMessageFaultMsg.getFaultInfo().getSubError().getErrorData());

        }
        return syncSendMessageResponse;
    }*/
    public kz.bee.bip.SyncChannel.v10.Types.response.SyncSendMessageResponse syncSendMessageResponse(
            kz.bee.bip.SyncChannel.v10.Types.request.SyncSendMessageRequest request) throws Exception,
            kz.bee.bip.SyncChannel.v10.Types.SendMessageSendMessageFaultMsg {

        kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannel iSyncChannel =
                new kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannelHttpService().getSyncChannelHttpPort();
        setEndpointAddress(iSyncChannel, "http://195.12.113.7/bip-sync-wss-gost/");
        return iSyncChannel.sendMessage(request);
    }
}

