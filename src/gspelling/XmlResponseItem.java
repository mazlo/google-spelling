package gspelling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * TODO improve docs
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
@XmlAccessorType(XmlAccessType.FIELD)
public final class XmlResponseItem {

    @XmlAttribute(name = "o")
    private int offset;

    @XmlAttribute(name = "l")
    private int length;

    @XmlValue
    private String text;

    public XmlResponseItem() {
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
