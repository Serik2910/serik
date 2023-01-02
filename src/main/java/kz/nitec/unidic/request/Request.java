
package kz.nitec.unidic.request;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Login" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EntityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Relevance" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="ConsiderTime" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SelectRequisites" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Requisite" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SortRequisites" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Requisite" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Direction">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Ascending"/>
 *                                   &lt;enumeration value="Descending"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
        "login",
        "password",
        "entityName",
        "relevance",
        "selectRequisites",
        "filter",
        "sortRequisites"
})
@XmlRootElement(name = "Request", namespace = "http://nitec.kz/unidic/ws/getdata")
public class Request {

    @XmlElement(name = "Login", required = true)
    protected String login;
    @XmlElement(name = "Password", required = true)
    protected String password;
    @XmlElement(name = "EntityName", required = true)
    protected String entityName;
    @XmlElement(name = "Relevance")
    protected Relevance relevance;
    @XmlElement(name = "SelectRequisites")
    protected SelectRequisites selectRequisites;
    @XmlElement(name = "Filter")
    protected String filter;
    @XmlElement(name = "SortRequisites")
    protected SortRequisites sortRequisites;

    /**
     * Gets the value of the login property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the entityName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Sets the value of the entityName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEntityName(String value) {
        this.entityName = value;
    }

    /**
     * Gets the value of the relevance property.
     *
     * @return possible object is
     * {@link Relevance }
     */
    public Relevance getRelevance() {
        return relevance;
    }

    /**
     * Sets the value of the relevance property.
     *
     * @param value allowed object is
     *              {@link Relevance }
     */
    public void setRelevance(Relevance value) {
        this.relevance = value;
    }

    /**
     * Gets the value of the selectRequisites property.
     *
     * @return possible object is
     * {@link SelectRequisites }
     */
    public SelectRequisites getSelectRequisites() {
        return selectRequisites;
    }

    /**
     * Sets the value of the selectRequisites property.
     *
     * @param value allowed object is
     *              {@link SelectRequisites }
     */
    public void setSelectRequisites(SelectRequisites value) {
        this.selectRequisites = value;
    }

    /**
     * Gets the value of the filter property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFilter(String value) {
        this.filter = value;
    }

    /**
     * Gets the value of the sortRequisites property.
     *
     * @return possible object is
     * {@link SortRequisites }
     */
    public SortRequisites getSortRequisites() {
        return sortRequisites;
    }

    /**
     * Sets the value of the sortRequisites property.
     *
     * @param value allowed object is
     *              {@link SortRequisites }
     */
    public void setSortRequisites(SortRequisites value) {
        this.sortRequisites = value;
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="ConsiderTime" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "date",
            "considerTime"
    })
    public static class Relevance {

        @XmlElement(name = "Date", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar date;
        @XmlElement(name = "ConsiderTime")
        protected boolean considerTime;

        /**
         * Gets the value of the date property.
         *
         * @return possible object is
         * {@link XMLGregorianCalendar }
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         *
         * @param value allowed object is
         *              {@link XMLGregorianCalendar }
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }

        /**
         * Gets the value of the considerTime property.
         */
        public boolean isConsiderTime() {
            return considerTime;
        }

        /**
         * Sets the value of the considerTime property.
         */
        public void setConsiderTime(boolean value) {
            this.considerTime = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Requisite" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "requisite"
    })
    public static class SelectRequisites {

        @XmlElement(name = "Requisite")
        protected List<Requisite> requisite;

        /**
         * Gets the value of the requisite property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the requisite property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRequisite().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Requisite }
         */
        public List<Requisite> getRequisite() {
            if (requisite == null) {
                requisite = new ArrayList<Requisite>();
            }
            return this.requisite;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "name",
                "alias"
        })
        public static class Requisite {

            @XmlElement(name = "Name")
            protected String name;
            @XmlElement(name = "Alias", required = true)
            protected String alias;

            /**
             * Gets the value of the name property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the alias property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getAlias() {
                return alias;
            }

            /**
             * Sets the value of the alias property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setAlias(String value) {
                this.alias = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Requisite" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Direction">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Ascending"/>
     *                         &lt;enumeration value="Descending"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "requisite"
    })
    public static class SortRequisites {

        @XmlElement(name = "Requisite")
        protected List<Requisite> requisite;

        /**
         * Gets the value of the requisite property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the requisite property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRequisite().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Requisite }
         */
        public List<Requisite> getRequisite() {
            if (requisite == null) {
                requisite = new ArrayList<Requisite>();
            }
            return this.requisite;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Direction">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Ascending"/>
         *               &lt;enumeration value="Descending"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "name",
                "direction"
        })
        public static class Requisite {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Direction", required = true)
            protected String direction;

            /**
             * Gets the value of the name property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the direction property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getDirection() {
                return direction;
            }

            /**
             * Sets the value of the direction property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setDirection(String value) {
                this.direction = value;
            }

        }

    }

}
