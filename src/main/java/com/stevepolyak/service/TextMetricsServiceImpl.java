package com.stevepolyak.service;

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
		text.setParagraphCount(paragraphDetector.count((text.getValue())));
		text.setSentenceCount(sentenceDetector.count((text.getValue())));
		text.setWordCount(wordDetector.count((text.getValue())));
		text.setResults(true);
		return text;
	}
}
