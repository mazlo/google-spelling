package gspelling;

/**
 * TODO improve docs
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
public enum GSpellingLanguage {

    DANISH("da"),

    GERMAN("de"),

    ENGLISH("en"),

    SPANISH("es"),

    FINNISH("fi"),

    FRENCH("fr"),

    ITALIAN("it"),

    DUTCH("nl"),

    POLISH("pl"),

    PORTUGUESE("pt"),

    PORTUGUESE_BR("br"),

    SWEDISH("sv");

    private final String code;

    private GSpellingLanguage(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
