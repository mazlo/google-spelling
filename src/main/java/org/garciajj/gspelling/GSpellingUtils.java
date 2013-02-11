package org.garciajj.gspelling;

import java.util.List;

public class GSpellingUtils
{

	/**
	 * Applys the <i>corrections</i> to <i>originalText</i>, but only the first
	 * correction returned by the google spelling api is taken into
	 * consideration. The correction is not applied, if there are no corrections
	 * or the correction text (suggestion) is empty.
	 * 
	 * @param originalText
	 * @param corrections
	 * @return
	 */
	public static String applyFirstSuggestion(String originalText, List<Word> corrections)
	{
		String ret = originalText;

		if ( originalText == null || originalText.length() == 0 )
			return ret;

		if ( corrections == null || corrections.size() == 0 )
			return ret;

		for ( Word word : corrections )
		{
			if ( word.getSuggestions() == null || word.getSuggestions().size() == 0 )
				continue;

			String suggestion = word.getSuggestions().get( 0 );

			if ( suggestion == null || suggestion.length() == 0 )
				continue;

			ret = ret.replaceAll( word.getValue(), suggestion );
		}

		return ret;
	}
}
