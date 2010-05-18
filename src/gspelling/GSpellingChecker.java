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

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Provides a spell check using the Google Spell.
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
public final class GSpellingChecker {

    /**
     * The service URL for querying.
     */
    private static final String SERVICE_URL = "https://www.google.com/tbproxy/spell?lang=%s";

    private static final Logger logger = Logger.getLogger(GSpellingChecker.class.getName());

    private static final String UNKNOWN_ERROR = "Google API returns an unknown error.";

    /**
     * Search the text to find spelling errors, and return the bad words.
     * 
     * @param text The text to spell.
     * @param lang The language. (optional)
     * @return The list of bad words in the input text or empty list if has no spelling errors.
     * @throws GSpellingException If an error occurs.
     */
    public static List<String> checkBadWords(String text, GSpellingLanguage lang)
        throws GSpellingException {
        final List<String> out = new LinkedList<String>();

        XmlResponse response = doSpelling(text, lang);
        for (XmlResponseItem item : response.getItems()) {
            out.add(text.substring(item.getOffset(), item.getOffset() + item.getLength()));
        }

        return out;
    }

    /**
     * Returns a list of suggestions for one or more words.
     * 
     * @param word The input word (can be one or more).
     * @param lang The language. (optional)
     * @return The list of suggestions for the input word(s).
     * @throws GSpellingException If an error occurs.
     */
    public static List<String> getSuggestions(String word, GSpellingLanguage lang)
        throws GSpellingException {
        final List<String> out = new LinkedList<String>();

        XmlResponse response = doSpelling(word, lang);
        for (XmlResponseItem item : response.getItems()) {
            String[] items = item.getText().split("\\t");
            out.addAll(Arrays.asList(items));
        }

        return out;
    }

    /**
     * Returns a list of {@link Word} object that contains the bad words and spell suggestions for own.
     * 
     * @param text The text to spell.
     * @param lang The language. (optional)
     * @return The list of bad words and spell suggestions for own.
     * @throws GSpellingException If an error occurs.
     */
    public static List<Word> checkWords(String text, GSpellingLanguage lang)
        throws GSpellingException {
        final List<Word> out = new LinkedList<Word>();

        XmlResponse response = doSpelling(text, lang);
        for (XmlResponseItem item : response.getItems()) {
            String key = text.substring(item.getOffset(), item.getOffset() + item.getLength());
            String[] suggestions = item.getText().split("\\t");

            out.add(new Word(key, Arrays.asList(suggestions)));
        }

        return out;
    }

    /**
     * Internal method that execute the remote query.
     * 
     * @param str
     * @param lang
     * @return
     * @throws GSpellingException
     */
    private static XmlResponse doSpelling(String str, GSpellingLanguage lang)
        throws GSpellingException {

        final XmlRequest request = new XmlRequest(str);
        OutputStream out = null;
        InputStream in = null;

        try {
            final URL url = new URL(String.format(SERVICE_URL, lang));
            final URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            out = conn.getOutputStream();

            JAXBContext ctx = JAXBContext.newInstance(XmlRequest.class, XmlResponse.class);

            ctx.createMarshaller().marshal(request, out);

            // get the result from GSpell
            in = conn.getInputStream();
            XmlResponse response = (XmlResponse) ctx.createUnmarshaller().unmarshal(in);

            // check if has errors
            if (response.isError()) {
                logger.log(Level.SEVERE, UNKNOWN_ERROR);
                throw new GSpellingException(UNKNOWN_ERROR);
            }

            return response;
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            throw new GSpellingException(e);

        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            throw new GSpellingException(e);

        } finally {
            // close streams
            closeQuietly(in);
            closeQuietly(out);
        }
    }

    /**
     * Close a {@link Closeable} resource ignoring if an error occurs.
     * 
     * @param closeable The {@link Closeable} object to close.
     */
    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            logger.log(Level.WARNING, "An exception occurs when closing resource", e);
        }
    }
}