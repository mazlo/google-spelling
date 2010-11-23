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
package gspelling.test;

import static gspelling.GSpellingLanguage.ENGLISH;
import gspelling.GSpellingChecker;
import gspelling.Word;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * A simple class to testing methods with JUnit.
 * 
 * @author Otávio Scherer Garcia
 */
public class GSpellingCheckerTest {

    @Test
    public void checkWords()
        throws Exception {
        List<Word> out = null;

        // with errors
        out = GSpellingChecker.checkWords("Boing is an amaing acraft", ENGLISH);
        System.out.println(out);
        Assert.assertTrue(out.size() > 0);

        // no errors
        out = GSpellingChecker.checkWords("Boeing is an amazing aircraft", ENGLISH);
        System.out.println(out);
        Assert.assertTrue(out.size() == 0);
    }

    @Test
    public void checkBadWords()
        throws Exception {
        List<String> out = null;

        // one error
        out = GSpellingChecker.checkBadWords("Boing aircraft", ENGLISH);
        System.out.println(out);
        Assert.assertTrue(out.contains("Boing"));

        // no errors
        out = GSpellingChecker.checkBadWords("Boeing aircraft", ENGLISH);
        System.out.println(out);
        Assert.assertTrue(out.size() == 0);
    }

    @Test
    public void getSuggestions()
        throws Exception {
        List<String> out = null;

        // one error
        out = GSpellingChecker.getSuggestions("Boing", ENGLISH);
        System.out.println(out);
        Assert.assertTrue(out.contains("Boeing"));

        // no errors
        out = GSpellingChecker.checkBadWords("Boeing", ENGLISH);
        System.out.println(out);
        Assert.assertTrue(out.size() == 0);
    }
}
