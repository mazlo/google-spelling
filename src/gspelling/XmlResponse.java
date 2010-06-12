/*
 * Copyright (C) 2010 Otávio Scherer Garcia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gspelling;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response envelope of remote service.
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
