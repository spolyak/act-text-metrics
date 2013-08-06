package com.stevepolyak.text;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.parser.charniak.CharniakParser;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.WordTokenFactory;

public class WordDetector {

	public int count(String text) {
		// CharniakParser cp = new CharniakParser();
		@SuppressWarnings("unchecked")
		PTBTokenizer<HasWord> ptbt = new PTBTokenizer(new StringReader(text),
				new WordTokenFactory(), "");
		List<Word> tokens = new ArrayList<Word>();
		for (Word token; ptbt.hasNext();) {
			token = (Word) ptbt.next();
			if (!token.word().trim().matches("\\.|,|-|\\?|!")) {
				tokens.add(token);
			}
		}
		return tokens.size();
	}

	Function<Word, String> wordToString = new Function<Word, String>() {
		public String apply(Word w) {
			return w.value();
		}
	};

	public String[] getWords(String text) {
		// CharniakParser cp = new CharniakParser();
		@SuppressWarnings("unchecked")
		PTBTokenizer<HasWord> ptbt = new PTBTokenizer(new StringReader(text),
				new WordTokenFactory(), "");
		List<Word> tokens = new ArrayList<Word>();
		for (Word token; ptbt.hasNext();) {
			token = (Word) ptbt.next();
			if (!token.word().trim().matches("\\.|,|-|\\?|!")) {
				tokens.add(token);
			}
		}
		List<String> wordsList = Lists.transform(tokens, wordToString);
		return wordsList.toArray(new String[(wordsList.size())]);
	}

}
