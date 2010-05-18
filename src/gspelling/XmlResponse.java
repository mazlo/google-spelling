package gspelling;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO improve docs
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
@XmlRootElement(name = "spellresult")
@XmlAccessorType(XmlAccessType.FIELD)
public final class XmlResponse {

    @XmlAttribute
    private boolean error;

    @XmlAttribute
    private boolean clipped;

    @XmlAttribute
    private boolean charschecked;

    @XmlElement(name = "c")
    private List<XmlResponseItem> items;

    public XmlResponse() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isClipped() {
        return clipped;
    }

    public void setClipped(boolean clipped) {
        this.clipped = clipped;
    }

    public boolean isCharschecked() {
        return charschecked;
    }

    public void setCharschecked(boolean charschecked) {
        this.charschecked = charschecked;
    }

    public List<XmlResponseItem> getItems() {
        if (items == null) {
            return Collections.emptyList();
        }

        return items;
    }

    public void setItems(List<XmlResponseItem> items) {
        this.items = items;
    }

}
