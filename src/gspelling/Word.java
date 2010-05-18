package gspelling;

import java.util.Collections;
import java.util.List;

/**
 * TODO improve docs
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
public class Word {

    private String value;

    private List<String> suggestions;

    public Word(String value, List<String> suggestions) {
        this.value = value;
        this.suggestions = Collections.unmodifiableList(suggestions);
    }

    public String getValue() {
        return value;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    @Override
    public String toString() {
        return value + "=" + suggestions;
    }

}
