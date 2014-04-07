package com.epam.feel.server.mail.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for message complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="message">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anonimous" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryTypes" type="{http://ejb.ws.mailer.epam.com/}dictionaryCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messageRecepients" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType (name = "message", propOrder = {"subject", "text", "anonimous", "sender", "deliveryTypes", "messageRecepients"})
public class Message {

    protected String subject;
    protected String text;
    protected Boolean anonimous;
    protected String sender;
    @XmlElement (nillable = true)
    protected List<DictionaryCode> deliveryTypes;
    @XmlElement (nillable = true)
    protected List<String> messageRecepients;

    /**
     * Gets the value of the subject property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the anonimous property.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isAnonimous() {
        return anonimous;
    }

    /**
     * Sets the value of the anonimous property.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setAnonimous(Boolean value) {
        this.anonimous = value;
    }

    /**
     * Gets the value of the sender property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSender(String value) {
        this.sender = value;
    }

    /**
     * Gets the value of the deliveryTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the deliveryTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getDeliveryTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link DictionaryCode }
     * 
     * 
     */
    public List<DictionaryCode> getDeliveryTypes() {
        if (deliveryTypes == null) {
            deliveryTypes = new ArrayList<DictionaryCode>();
        }
        return this.deliveryTypes;
    }

    /**
     * Gets the value of the messageRecepients property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the messageRecepients property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getMessageRecepients().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     * 
     * 
     */
    public List<String> getMessageRecepients() {
        if (messageRecepients == null) {
            messageRecepients = new ArrayList<String>();
        }
        return this.messageRecepients;
    }

}
