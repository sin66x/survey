package com.roozaneh.survey.config.messageloader;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/15/18
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name="parts")
public class Parts {

    @XmlElement(name="part")
    public List<Part> parts;
}
