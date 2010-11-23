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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The request envelope to use remote service.
 * 
 * @author Otávio Scherer Garcia
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
