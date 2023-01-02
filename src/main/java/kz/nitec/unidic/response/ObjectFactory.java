
package kz.nitec.unidic.response;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kz.nitec.unidic.response package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kz.nitec.unidic.response
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link Response.ResultData }
     * 
     */
    public Response.ResultData createResponseResultData() {
        return new Response.ResultData();
    }

    /**
     * Create an instance of {@link Response.ErrorInfo }
     * 
     */
    public Response.ErrorInfo createResponseErrorInfo() {
        return new Response.ErrorInfo();
    }

    /**
     * Create an instance of {@link Response.ResultData.Data }
     * 
     */
    public Response.ResultData.Data createResponseResultDataData() {
        return new Response.ResultData.Data();
    }

    /**
     * Create an instance of {@link Response.ResultData.Schema }
     * 
     */
    public Response.ResultData.Schema createResponseResultDataSchema() {
        return new Response.ResultData.Schema();
    }

}
