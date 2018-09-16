package com.roozaneh.survey.config.messageloader;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


@XmlRootElement(name = "message")
public class Message {

    @XmlAttribute(name="id")
    public String id;

    @XmlElement(name="text")
    public List<Text> texts;

    private static Messages inst;

    public String getText(String lang) {
        for (Text text : texts){
            if (lang.equals(text.lang)){
                return text.value;
            }
        }
        return "";
    }
}
