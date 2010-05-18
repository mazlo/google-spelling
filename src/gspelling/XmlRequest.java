package gspelling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO improve docs
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
@XmlRootElement(name = "spellrequest")
@XmlAccessorType(XmlAccessType.FIELD)
public final class XmlRequest {

    public XmlRequest() {
    }

    private String text;

    public XmlRequest(String text) {
        // google don't like null values :o)
        this.text = (text == null ? "" : text);
    }

    public String getText() {
        return text;
    }

}
