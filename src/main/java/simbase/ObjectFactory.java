
package simbase;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.simourg.simbase package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.simourg.simbase
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Sbapi }
     * 
     */
    public Sbapi createSbapi() {
        return new Sbapi();
    }

    /**
     * Create an instance of {@link Sbapi.Body }
     * 
     */
    public Sbapi.Body createSbapiBody() {
        return new Sbapi.Body();
    }

    /**
     * Create an instance of {@link Sbapi.Header }
     * 
     */
    public Sbapi.Header createSbapiHeader() {
        return new Sbapi.Header();
    }

    /**
     * Create an instance of {@link Sbapi.Body.Function }
     * 
     */
    public Sbapi.Body.Function createSbapiBodyFunction() {
        return new Sbapi.Body.Function();
    }

    /**
     * Create an instance of {@link Sbapi.Header.Interface }
     * 
     */
    public Sbapi.Header.Interface createSbapiHeaderInterface() {
        return new Sbapi.Header.Interface();
    }

    /**
     * Create an instance of {@link Sbapi.Header.Message }
     * 
     */
    public Sbapi.Header.Message createSbapiHeaderMessage() {
        return new Sbapi.Header.Message();
    }

    /**
     * Create an instance of {@link Sbapi.Header.Error }
     * 
     */
    public Sbapi.Header.Error createSbapiHeaderError() {
        return new Sbapi.Header.Error();
    }

    /**
     * Create an instance of {@link Sbapi.Header.Auth }
     * 
     */
    public Sbapi.Header.Auth createSbapiHeaderAuth() {
        return new Sbapi.Header.Auth();
    }

}
