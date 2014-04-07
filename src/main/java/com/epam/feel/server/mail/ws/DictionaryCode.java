package com.epam.feel.server.mail.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for dictionaryCode.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="dictionaryCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="email"/>
 *     &lt;enumeration value="sms"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType (name = "dictionaryCode")
@XmlEnum
public enum DictionaryCode {

    @XmlEnumValue ("email")
    EMAIL("email"), @XmlEnumValue ("sms")
    SMS("sms");
    private final String value;

    DictionaryCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DictionaryCode fromValue(String v) {
        for (DictionaryCode c : DictionaryCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
