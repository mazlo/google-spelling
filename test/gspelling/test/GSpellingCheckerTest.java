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
 * @version $Revision$
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
