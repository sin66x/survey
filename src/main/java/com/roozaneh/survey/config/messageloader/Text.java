package com.roozaneh.survey.config.messageloader;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name="text")
public class Text {
    @XmlAttribute
    public String lang;

    @XmlValue
    public String value;

}
