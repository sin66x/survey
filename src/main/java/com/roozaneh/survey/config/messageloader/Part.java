package com.roozaneh.survey.config.messageloader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/15/18
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Part {

    @XmlAttribute
    private String id;

    @XmlValue
    private String value;

    private static Parts inst;
    static {
        try {

            File file = new File("src/main/resources/Parts.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Parts.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            inst = (Parts) jaxbUnmarshaller.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getPart(String id) {
        for (Part part : inst.parts){
            if (id.equals(part.id)){
                return part.value;
            }

        }
        return "";
    }
}
