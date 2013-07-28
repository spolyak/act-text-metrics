package com.stevepolyak.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stevepolyak.model.Text;
import com.stevepolyak.text.ParagraphDetector;
import com.stevepolyak.text.SentenceDetector;
import com.stevepolyak.text.WordDetector;

@Service
public class TextMetricsServiceImpl implements TextMetricsService {

	ParagraphDetector paragraphDetector;
	SentenceDetector sentenceDetector;
	WordDetector wordDetector;
	
	public TextMetricsServiceImpl() {
		paragraphDetector = new ParagraphDetector();
		sentenceDetector = new SentenceDetector();
		wordDetector = new WordDetector();
	}

	@Override
	public Text compute(Text text) {
		String value = text.getValue();
		text.setParagraphCount(paragraphDetector.count(value));
		text.setParagraphs(paragraphDetector.getParagraphs(value));

		List<Integer> lengths = new ArrayList<Integer>();
		for(String paragraph : text.getParagraphs()) {
			lengths.add(wordDetector.count(paragraph));
		}
		text.setParagraphLengths(lengths.toArray(new Integer[(lengths.size())]));
		
		text.setSentenceCount(sentenceDetector.count(value));
		text.setWordCount(wordDetector.count(value));
		text.setResults(true);
		return text;
	}
}
