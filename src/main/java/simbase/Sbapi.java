package simbase;

import com.sun.istack.NotNull;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "header",
        "body"
})
@XmlRootElement(name = "sbapi")
public class Sbapi {

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
            "function"
    })
    public static class Body {

        @XmlElement(required = true)
        protected Function function;

        public Function getFunction() {
            return function;
        }

        public void setFunction(Function value) {
            this.function = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "arg"
        })
        public static class Function {

            protected List<Arg> arg;
            @XmlAttribute(name = "name")
            protected String name;

            public List<Arg> getArg() {
                if (arg == null) {
                    arg = new ArrayList<>();
                }
                return this.arg;
            }

            public void addArg(@NotNull String name, String value) {
                if (value != null && !value.isEmpty()) {
                    Arg arg = new Arg();
                    arg.setName(name);
                    arg.setValue(value);
                    getArg().add(arg);
                }
            }

            public String getName() {
                return name;
            }

            public void setName(String value) {
                this.name = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "value"
            })
            public static class Arg {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "name")
                protected String name;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getName() {
                    return name;
                }

                public void setName(String value) {
                    this.name = value;
                }

            }

        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "_interface",
            "message",
            "error",
            "auth"
    })
    public static class Header {

        @XmlElement(name = "interface", required = true)
        protected Interface _interface;
        @XmlElement(required = true)
        protected Message message;
        @XmlElement(required = true)
        protected Error error;
        @XmlElement(required = true)
        protected Auth auth;

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

        public Auth getAuth() {
            return auth;
        }

        public void setAuth(Auth value) {
            this.auth = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class Auth {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "pwd")
            protected String pwd;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getPwd() {
                return pwd;
            }

            public void setPwd(String value) {
                this.pwd = value;
            }

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
