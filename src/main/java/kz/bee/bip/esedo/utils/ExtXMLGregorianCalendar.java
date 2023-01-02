package kz.bee.bip.esedo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * class
 * TODO
 */
public class ExtXMLGregorianCalendar {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtXMLGregorianCalendar.class.getName());

    private XMLGregorianCalendar xmlGregorianCalendar;

    /**
     * .ctro
     * TODO
     */
    public ExtXMLGregorianCalendar(){
        try {
            GregorianCalendar gCalendar = new GregorianCalendar();
            gCalendar.setTime(new Date());
            this.xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
            this.xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e) {
            LOGGER.error(e.toString(), e);
        }
    }

    /**
     * .ctor
     * TODO
     * @param date
     */
    public ExtXMLGregorianCalendar(Date date){
        try {
            GregorianCalendar gCalendar = new GregorianCalendar();
            gCalendar.setTime(date);
            this.xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
            this.xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e) {
            LOGGER.error(e.toString(), e);
        }
    }

    /**
     * .ctor
     * TODO
     * @param date
     */
    public ExtXMLGregorianCalendar(String date){
        try {
            this.xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
            this.xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e) {
            LOGGER.error(e.toString(), e);
        }
    }

    /**
     * method
     * TODO
     * @return
     */
    public XMLGregorianCalendar xmlGregorianCalendar(){
        return  this.xmlGregorianCalendar;
    }
}
