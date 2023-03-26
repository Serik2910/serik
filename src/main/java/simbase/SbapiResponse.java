package simbase;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "header",
        "body"
})
@XmlRootElement(name = "sbapi")
public class SbapiResponse {

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header value) {
        this.header = value;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body value) {
        this.body = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "status",
            "result"
    })
    public static class Body {

        @XmlElement(required = true)
        protected String status;

        @XmlElement(required = true)
        protected String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "_interface",
            "message",
            "error"

    })
    public static class Header {

        @XmlElement(name = "interface", required = true)
        protected Interface _interface;
        @XmlElement(required = true)
        protected Message message;
        @XmlElement(required = true)
        protected Error error;


        public Interface getInterface() {
            return _interface;
        }

        public void setInterface(Interface value) {
            this._interface = value;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message value) {
            this.message = value;
        }

        public Error getError() {
            return error;
        }

        public void setError(Error value) {
            this.error = value;
        }




        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class Error {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected String id;
            @XmlAttribute(name = "text")
            protected String text;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getId() {
                return id;
            }

            public void setId(String value) {
                this.id = value;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class Interface {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected String id;
            @XmlAttribute(name = "version")
            protected String version;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getId() {
                return id;
            }

            public void setId(String value) {
                this.id = value;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String value) {
                this.version = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class Message {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "ignore_id")
            protected String ignoreId;
            @XmlAttribute(name = "id")
            protected String id;
            @XmlAttribute(name = "type")
            protected String type;
            @XmlAttribute(name = "created")
            protected String created;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getIgnoreId() {
                return ignoreId;
            }

            public void setIgnoreId(String value) {
                this.ignoreId = value;
            }

            public String getId() {
                return id;
            }

            public void setId(String value) {
                this.id = value;
            }

            public String getType() {
                return type;
            }

            public void setType(String value) {
                this.type = value;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String value) {
                this.created = value;
            }

        }
    }

}
