package kz.nitec.unidic.Types.request;

import kz.nitec.unidic.request.Request;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "Request"
})

public class Data {

    @XmlElement(name = "Request", namespace = "http://nitec.kz/unidic/ws/getdata")
    protected Request Request;

    public Request getRequest() {
        return this.Request;
    }

    public void setRequest(Request request) {
        this.Request = request;
    }
}
