package com.roozaneh.survey.config.messageloader;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "text")
public class Text {

    @XmlAttribute
    String lang;

    @XmlValue
    String value;

}
