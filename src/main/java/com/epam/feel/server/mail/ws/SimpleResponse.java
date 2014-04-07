package com.epam.feel.server.mail.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SimpleResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errcode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType (name = "SimpleResponse", propOrder = {"errcode", "description"})
public class SimpleResponse {

    protected int errcode;
    protected String description;

    /**
     * Gets the value of the errcode property.
     * 
     */
    public int getErrcode() {
        return errcode;
    }

    /**
     * Sets the value of the errcode property.
     * 
     */
    public void setErrcode(int value) {
        this.errcode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
