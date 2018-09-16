package com.roozaneh.survey.config.messageloader;

import com.roozaneh.survey.model.TestModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.io.File;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name="messages")
public class Messages {

    public static Messages inst;

   @XmlElement(name="message")
    public List<Message> messages;

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

    public String getMessage(String id, String lang) {
        for (Message message : inst.messages){
            if (id.equals(message.id)){
                return message.getText(lang);
            }

        }
        return "";
    }
}
