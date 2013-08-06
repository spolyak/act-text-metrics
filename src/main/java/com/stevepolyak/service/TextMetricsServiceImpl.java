package com.stevepolyak.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stevepolyak.model.Text;
import com.stevepolyak.text.ParagraphDetector;
import com.stevepolyak.text.SentenceDetector;
import com.stevepolyak.text.SyllableDetector;
import com.stevepolyak.text.WordDetector;

@Service
public class TextMetricsServiceImpl implements TextMetricsService {

	ParagraphDetector paragraphDetector;
	SentenceDetector sentenceDetector;
	WordDetector wordDetector;
	SyllableDetector syllableDetector;
	
	public TextMetricsServiceImpl() {
		paragraphDetector = new ParagraphDetector();
		sentenceDetector = new SentenceDetector();
		wordDetector = new WordDetector();
		syllableDetector = new SyllableDetector();
	}

	@Override
	public Text compute(Text text) {
		String value = text.getValue();
		text.setParagraphCount(paragraphDetector.count(value));
		text.setParagraphs(paragraphDetector.getParagraphs(value));

		List<Integer> plengths = new ArrayList<Integer>();
		List<Integer> pslengths = new ArrayList<Integer>();
		for(String paragraph : text.getParagraphs()) {
			plengths.add(wordDetector.count(paragraph));
			pslengths.add(sentenceDetector.count(paragraph));
		}
		text.setParagraphLengths(plengths.toArray(new Integer[(plengths.size())]));
		text.setParagraphSentenceLengths(pslengths.toArray(new Integer[(pslengths.size())]));
		
		text.setSentenceCount(sentenceDetector.count(value));
		
		text.setSentences(sentenceDetector.getSentences(value));
		List<Integer> slengths = new ArrayList<Integer>();
		for(String sentence : text.getSentences()) {
			slengths.add(wordDetector.count(sentence));
		}
		text.setSentenceLengths(slengths.toArray(new Integer[(slengths.size())]));
		
		text.setWordCount(wordDetector.count(value));
		text.setWords(wordDetector.getWords(value));
		
		List<Integer> wslengths = new ArrayList<Integer>();
		List<Integer> wordlengths = new ArrayList<Integer>();
		int syllabelCount = 0;
		int letterCount = 0;
		for(String word : text.getWords()) {
			int wsresult = syllableDetector.count(word);
			wslengths.add(wsresult);
			wordlengths.add(word.length());
			letterCount += word.length();
			syllabelCount += wsresult;		
		}
		text.setSyllableCounts(wslengths.toArray(new Integer[(wslengths.size())]));
		text.setSyllabelCount(syllabelCount);
		text.setWordLengths(wordlengths.toArray(new Integer[(wordlengths.size())]));
		text.setLetterCount(letterCount);
		
		text.setResults(true);
		return text;
	}
}
