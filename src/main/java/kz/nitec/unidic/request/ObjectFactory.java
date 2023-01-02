
package kz.nitec.unidic.request;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kz.nitec.unidic.request package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kz.nitec.unidic.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Request.SortRequisites }
     * 
     */
    public Request.SortRequisites createRequestSortRequisites() {
        return new Request.SortRequisites();
    }

    /**
     * Create an instance of {@link Request.SelectRequisites }
     * 
     */
    public Request.SelectRequisites createRequestSelectRequisites() {
        return new Request.SelectRequisites();
    }

    /**
     * Create an instance of {@link Request.Relevance }
     * 
     */
    public Request.Relevance createRequestRelevance() {
        return new Request.Relevance();
    }

    /**
     * Create an instance of {@link Request.SortRequisites.Requisite }
     * 
     */
    public Request.SortRequisites.Requisite createRequestSortRequisitesRequisite() {
        return new Request.SortRequisites.Requisite();
    }

    /**
     * Create an instance of {@link Request.SelectRequisites.Requisite }
     * 
     */
    public Request.SelectRequisites.Requisite createRequestSelectRequisitesRequisite() {
        return new Request.SelectRequisites.Requisite();
    }

}
