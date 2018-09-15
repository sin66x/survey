package com.roozaneh.survey.config.messageloader;

import com.roozaneh.survey.model.TestModel;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
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

   @XmlElement(name="message")
    public List<Message> messages;

}
