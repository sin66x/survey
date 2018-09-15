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


    static {
        try {

            File file = new File("src/main/resources/messages.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Messages.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            inst = (Messages) jaxbUnmarshaller.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getMessage(String id, String lang) {
        for (Message message : inst.messages){
            if (id.equals(message.id)){
                return message.getText(lang);
            }

        }
        return "";
    }

    public String getText(String lang) {
        System.out.println(texts.size());
        for (Text text : texts){
            System.out.println(text.lang+"  "+text.value);
            if (lang.equals(text.lang)){
                return text.value;
            }
        }
        return "";
    }
}
