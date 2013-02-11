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
package org.garciajj.gspelling;

/**
 * Exception that wraps all aplication exceptions.
 * 
 * @author Otávio Scherer Garcia
 */
public class GSpellingException
    extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 4210348840420615917L;

    public GSpellingException() {
        super();
    }

    public GSpellingException(String message, Throwable cause) {
        super(message, cause);
    }

    public GSpellingException(String message) {
        super(message);
    }

    public GSpellingException(Throwable cause) {
        super(cause);
    }
}
