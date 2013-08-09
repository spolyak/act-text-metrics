package com.stevepolyak.text;

import java.util.Map;
import java.util.regex.Pattern;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class SyllableDetector2 {

	/**
	 * EnglishSyllableCounter: Counts syllables in English words.
	 * 
	 * <p>
	 * This syllable counter uses a two-stage process for counting syllables in
	 * a word.
	 * </p>
	 * 
	 * <ol>
	 * <li>The word is first looked up in a dictionary which maps words to their
	 * syllable counts. When the word is found in the dictionary, the associated
	 * syllable count is returned.</li>
	 * <li>When the word does not appear in the dictionary, the syllable count
	 * is computed from the number of vowel groups in the word. Adjustments are
	 * made for silent final "e"s and certain other letter groups.
	 * </ol>
	 * 
	 * <p>
	 * Most of the data used to construct the dictionary of syllable counts
	 * comes from a pronunciation dictionary provided by Carnegie-Mellon
	 * University.
	 * </p>
	 * 
	 * <p>
	 * The code used to compute syllable counts for words not found in the
	 * syllable counts dictionary is based upon that written by Greg Fast in
	 * Perl and Larry Ogrodnek in Java. Their methods provide the correct
	 * syllable count about 85-90% of the time. Rarely is the syllable count
	 * wrong by more than one.
	 * </p>
	 */

		/** Path to map from spellings to syllable counts. */

		protected String syllableCountFileName = "resources/englishsyllablecounts.tab";

		/** Map of spellings to syllable counts. */

		protected  Map<String, Integer> syllableCountMap = MapFactory
				.createNewMap();

		protected  final Pattern[] SubtractSyllables = new Pattern[] {
				Pattern.compile("cial"), Pattern.compile("tia"),
				Pattern.compile("cius"),
				Pattern.compile("cious"),
				Pattern.compile("giu"), // belgium!
				Pattern.compile("ion"), Pattern.compile("iou"),
				Pattern.compile("sia$"), Pattern.compile(".ely$") // absolutely!
																	// (but not
																	// ely!)
		};

		protected  final Pattern[] AddSyllables = new Pattern[] {
				Pattern.compile("ia"), Pattern.compile("riet"),
				Pattern.compile("dien"), Pattern.compile("iu"),
				Pattern.compile("io"), Pattern.compile("ii"),
				Pattern.compile("[aeiouym]bl$"), // -Vble, plus -mble
				Pattern.compile("[aeiou]{3}"), // agreeable
				Pattern.compile("^mc"), Pattern.compile("ism$"), // -isms
				Pattern.compile("([^aeiouy])\1l$"), // middle twiddle battle
													// bottle, etc.
				Pattern.compile("[^l]lien"), // alien, salient [1]
				Pattern.compile("^coa[dglx]."), // [2]
				Pattern.compile("[^gq]ua[^auieo]"), // i think this fixes more
													// than it breaks
				Pattern.compile("dnt$") // couldn't
		};

		/** Create an English syllable counter. */

		public SyllableDetector2() {
			try {
				syllableCountMap = loadSyllableCountMap(
						SyllableDetector2.class
								.getResource(syllableCountFileName),
						"\t", "", "utf-8");
			} catch (Exception e) {
			}
		}

		/**
		 * Load syllable counts map from a URL.
		 * 
		 * @param mapURL
		 *            URL for map file.
		 * @param separator
		 *            Field separator.
		 * @param qualifier
		 *            Quote character.
		 * @param encoding
		 *            Character encoding for the file.
		 * 
		 * @throws FileNotFoundException
		 *             If input file does not exist.
		 * @throws IOException
		 *             If input file cannot be opened.
		 * 
		 * @return Map with values read from file.
		 */

		public Map<String, Integer> loadSyllableCountMap(URL mapURL,
				String separator, String qualifier, String encoding)
				throws IOException, FileNotFoundException {
			Map<String, Integer> map = MapFactory.createNewMap();

			if (mapURL != null) {
				BufferedReader bufferedReader = new BufferedReader(
						new UnicodeReader(mapURL.openStream(), encoding));

				String inputLine = bufferedReader.readLine();
				String[] tokens;
				int count;

				while (inputLine != null) {
					tokens = inputLine.split(separator);

					if (tokens.length > 1) {
						// Convert count token to a number.

						count = Integer.parseInt(tokens[1]);

						map.put(tokens[0], count);
					}

					inputLine = bufferedReader.readLine();
				}

				bufferedReader.close();
			}

			return map;
		}

		/**
		 * Find number of syllables in a single English word.
		 * 
		 * @param word
		 *            The word whose syllable count is desired.
		 * 
		 * @return The number of syllables in the word.
		 */

		public int countSyllables(String word) {
			int result = 0;

			// Null or empty word?
			// Syllable count is zero.

			if ((word == null) || (word.length() == 0)) {
				return result;
			}
			// If word is in the dictionary,
			// return the syllable count from the
			// dictionary.

			String lcWord = word.toLowerCase();

			if (syllableCountMap.containsKey(lcWord)) {
				result = syllableCountMap.get(lcWord);
			}
			// If word is not in the dictionary,
			// use vowel group counting to get
			// the estimated syllable count.
			else {
				// Remove embedded apostrophes and
				// terminal e.

				lcWord = lcWord.replaceAll("'", "").replaceAll("e$", "");

				// Split word into vowel groups.

				String[] vowelGroups = lcWord.split("[^aeiouy]+");

				// Handle special cases.

				// Subtract from syllable count
				// for these patterns.

				for (Pattern p : SubtractSyllables) {
					Matcher m = p.matcher(lcWord);

					if (m.find()) {
						result--;
					}
				}
				// Add to syllable count for these patterns.

				for (Pattern p : AddSyllables) {
					Matcher m = p.matcher(lcWord);

					if (m.find()) {
						result++;
					}
				}

				if (lcWord.length() == 1) {
					result++;
				}
				// Count vowel groupings.

				if ((vowelGroups.length > 0) && (vowelGroups[0].length() == 0)) {
					result += vowelGroups.length - 1;
				} else {
					result += vowelGroups.length;
				}
			}
			// Return syllable count of
			// at least one.

			return Math.max(result, 1);
		}
	}