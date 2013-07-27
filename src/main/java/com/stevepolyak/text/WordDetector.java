package com.stevepolyak.text;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.parser.charniak.CharniakParser;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.WordTokenFactory;

public class WordDetector {

	@SuppressWarnings("unused")
	public int count(String text) {
		CharniakParser cp = new CharniakParser();
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
}
